package ro.pickupservice.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.request.GetOrdersInAreaRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.services.order.OrderService;

import java.util.List;

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

	@RequestMapping(value = "/getOrderById/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
		OrderDto response= orderService.getOrderById(orderId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getOrdersByUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable Long userId) {
		List<OrderDto> response = orderService.getOrderByUserId(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getOrdersInArea", method = RequestMethod.POST)
	public ResponseEntity<List<OrderDto>> getOrdersInArea(@RequestBody GetOrdersInAreaRequest request) {
		List<OrderDto> response = orderService.getOrdersInArea(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
