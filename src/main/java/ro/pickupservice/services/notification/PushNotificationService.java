package ro.pickupservice.services.notification;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PushNotificationService {

	private static final String FIREBASE_SERVER_KEY = "AAAADOYlxq8:APA91bG5LGLnk1IDI9MBFPNxb1eHJWHEs8Nc3Dje940SxqklHPHJsoAjgiYnORwsuz4stC_Iw__Lm8vMd066Lw8XfSY0ia75XVi1cLfjXEZGO4GwzS-9iwKSqbk90XI7zPv-2qxd3_RO";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	private final String TOPIC = "JavaSampleApproach";
	
	
	public String pushNotification() throws JSONException{
		
		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", "JSA Notification");
		notification.put("body", "Happy Message!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");
 
		body.put("notification", notification);
		body.put("data", data);
		
		HttpEntity<String> request = new HttpEntity<>(body.toString());
		
		CompletableFuture<String> response = this.send(request);
		CompletableFuture.allOf(response).join();
		
		try {
			String firebaseResp =  response.get();
			return firebaseResp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Async
	private CompletableFuture<String> send(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		/**
		https://fcm.googleapis.com/fcm/send
		Content-Type:application/json
		Authorization:key=FIREBASE_SERVER_KEY*/

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
}