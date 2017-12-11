package ro.pickupservice.services.order;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import ro.pickupservice.config.auth.AuthService;
import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.data.coordinates.entity.Coordinates;
import ro.pickupservice.data.order.OrderRepository;
import ro.pickupservice.data.order.entity.Order;
import ro.pickupservice.data.user.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private AuthService authService;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	HashOperations<String, String, Coordinates> hashOperations = redisTemplate.opsForHash();
	
	@Autowired
	private UserRepository userRepository;
	
	public CreateOrderResponse createOrder(CreateOrderRequest request, Principal principal) {
		CreateOrderResponse response = new CreateOrderResponse();
		Authentication authentication = authService.getAuthenticatedUser();
		
		Order order = new Order();
		
		orderRepository.saveAndFlush(order);
		return response;
	}
}
