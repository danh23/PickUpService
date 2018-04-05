package ro.pickupservice.controllers.notification;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.controllers.notification.bean.DriverToClientNotification;
import ro.pickupservice.controllers.notification.bean.NearbyOrderNotification;
import ro.pickupservice.services.notification.PushNotificationService;

@RestController
@RequestMapping(value = "/pushNotification", produces = "application/json")
public class NotificationController {
	
	
	@Autowired
	private PushNotificationService pushNotificationService;

	@RequestMapping(value = "/notifyClient", method = RequestMethod.POST)
	public ResponseEntity<String> notifyClient(@RequestBody DriverToClientNotification request) throws Exception {
		String response = pushNotificationService.notifyClient(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/nearbyOrderNotification", method = RequestMethod.POST)
	public ResponseEntity<String> notifyDriverForNearbyOrder(@RequestBody NearbyOrderNotification request) throws Exception {
		String response = pushNotificationService.notifyDriverForNearbyOrder(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
