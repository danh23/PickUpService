package ro.pickupservice.controllers.notification;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.controllers.notification.bean.DriverToClientNotification;
import ro.pickupservice.controllers.notification.bean.Message;
import ro.pickupservice.controllers.notification.bean.NearbyOrderNotification;
import ro.pickupservice.controllers.notification.bean.OutputMessage;
import ro.pickupservice.controllers.user.bean.response.UserDto;
import ro.pickupservice.services.notification.PushNotificationService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/pushNotification", produces = "application/json")
public class NotificationController {

	private final SimpMessagingTemplate template;

	@Autowired
	NotificationController(SimpMessagingTemplate template){
		this.template = template;
	}
	
	
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

    @MessageMapping("/socket")
    @SendTo("/topic/messages")
    public OutputMessage send(Principal principal, Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
