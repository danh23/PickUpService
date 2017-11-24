package ro.pickupservice.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

@Configuration
public class FirebaseConfig {
	

	public static String getAccessToken() {
		
		try {
			FileInputStream serviceAccount = new FileInputStream("./../config/pickup-serviceAccount.json");
			
			GoogleCredential googleCredential = GoogleCredential
				      .fromStream(new FileInputStream("service-account.json"))
				      .createScoped(Arrays.asList("READ"));
				  googleCredential.refreshToken();
				  System.out.println(googleCredential.getAccessToken());
				  return googleCredential.getAccessToken();
		} catch(Exception e) {
			
		}
		return null;
		  
	}

}
