package ro.pickupservice.controllers.notification;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.services.notification.PushNotificationService;

@RestController
@RequestMapping(value = "/pushNotification", produces = "application/json")
public class NotificationController {
	
	
	@Autowired
	private PushNotificationService pushNotificationService;
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ResponseEntity<String> sendNotification() throws JSONException {
		String response = pushNotificationService.pushNotification();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
