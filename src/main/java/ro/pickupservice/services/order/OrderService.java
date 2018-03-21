package ro.pickupservice.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.config.auth.AuthService;
import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.data.order.OrderMapper;
import ro.pickupservice.data.order.OrderProvider;
import ro.pickupservice.data.order.entity.Order;
import ro.pickupservice.data.user.UserRepository;

@Service
public class OrderService {

    @Autowired
    private AuthService authService;

    @Autowired
    private OrderProvider orderProvider;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    //HashOperations<String, String, Coordinates> hashOperations = redisTemplate.opsForHash();

    @Autowired
    private UserRepository userRepository;

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();

        Order order = OrderMapper.mapOrderRequestToOrder(request);

        orderProvider.createOrder(order);
        return response;
    }

    public OrderDto getOrderById(Long orderId) {
        ro.pickupservice.data.order.entity.Order order = orderProvider.getOrder(orderId);
        OrderDto orderDto = OrderMapper.mapOrderToOrderDto(order);
        return orderDto;
    }
}
