package ro.pickupservice.controllers.order;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.services.order.OrderService;

@RestController
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request, Principal principal) {
		CreateOrderResponse response = orderService.createOrder(request, principal);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
