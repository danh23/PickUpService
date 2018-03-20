package ro.pickupservice.controllers.order;

import java.security.Principal;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.services.order.OrderService;

@RestController
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
		CreateOrderResponse response = orderService.createOrder(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getOrderById/{orderId}", method = RequestMethod.POST)
	public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
		OrderDto response= orderService.getOrderById(orderId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
