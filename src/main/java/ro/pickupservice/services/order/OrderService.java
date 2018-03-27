package ro.pickupservice.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.bean.Location;
import ro.pickupservice.config.auth.AuthService;
import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.request.GetOrdersInAreaRequest;
import ro.pickupservice.controllers.order.bean.response.CreateOrderResponse;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.controllers.order.bean.response.OrderSummary;
import ro.pickupservice.data.order.OrderMapper;
import ro.pickupservice.data.order.OrderProvider;
import ro.pickupservice.data.order.entity.Order;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.services.user.UserService;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private AuthService authService;

    @Autowired
    private OrderProvider orderProvider;

    @Autowired
    private UserService userService;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    //HashOperations<String, String, Coordinates> hashOperations = redisTemplate.opsForHash();

    @Autowired
    private UserRepository userRepository;

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();

        User user = userRepository.findOne(request.getUserId());

        Order order = OrderMapper.mapOrderRequestToOrder(request, user);

        orderProvider.createOrder(order);
        response.setId(order.getId());
        return response;
    }

    public OrderDto getOrderById(Long orderId) {
        Order order = orderProvider.getOrder(orderId);
        OrderDto orderDto = OrderMapper.mapOrderToOrderDto(order);
        return orderDto;
    }

    public List<OrderDto> getOrdersByUserId(Long userId) {
        List<Order> orders = orderProvider.getOrdersByUserId(userId);
        List<OrderDto> orderDtos = OrderMapper.mapOrdersToOrderDtoList(orders);
        return orderDtos;
    }

    public List<OrderSummary> getOrdersInArea(GetOrdersInAreaRequest request) {
        Location location = request.getLocation();
        Float offset = request.getOffset();
        List<Order> orders = orderProvider.getOrdersInArea(location.getLatitude(), location.getLongitude(), offset);
        List<OrderSummary> orderDtos = OrderMapper.mapOrdersToOrderSummaryList(orders);
        return orderDtos;
    }
}
