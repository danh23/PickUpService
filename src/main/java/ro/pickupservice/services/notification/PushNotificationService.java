package ro.pickupservice.services.notification;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.pickupservice.constants.NotificationScope;
import ro.pickupservice.controllers.notification.bean.DriverToClientNotification;
import ro.pickupservice.controllers.notification.bean.NearbyOrderNotification;
import ro.pickupservice.data.user.UserProvider;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.services.user.UserService;

@Service
public class PushNotificationService {

	@Autowired
	private UserProvider userProvider;

	@Autowired
	private ObjectMapper objectMapper;

	private static final String FIREBASE_SERVER_KEY = "AAAADOYlxq8:APA91bG5LGLnk1IDI9MBFPNxb1eHJWHEs8Nc3Dje940SxqklHPHJsoAjgiYnORwsuz4stC_Iw__Lm8vMd066Lw8XfSY0ia75XVi1cLfjXEZGO4GwzS-9iwKSqbk90XI7zPv-2qxd3_RO";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

	public String notifyClient(DriverToClientNotification request) throws JsonProcessingException {
		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + request.getTopic());
		body.put("priority", "high");

		User user = userProvider.findUserById(request.getDriverId());

		JSONObject notification = new JSONObject();
		if(request.getScope().equals(NotificationScope.START)) {
			notification.put("title", "Order taken!");
			notification.put("body", "Order " + request.getOrderTitle() + " taken by " + user.getFirstName() + " " + user.getLastName());
		}
		JSONObject data = new JSONObject();
		data.put("request", objectMapper.writeValueAsString(request));

		body.put("notification", notification);
		body.put("data", data);

		HttpEntity<String> httpRequest = new HttpEntity<>(body.toString());

		CompletableFuture<String> response = this.send(httpRequest);
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

	public String notifyDriverForNearbyOrder(NearbyOrderNotification request) {
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
