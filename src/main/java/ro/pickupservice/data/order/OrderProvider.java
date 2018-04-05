package ro.pickupservice.data.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.order.entity.Order;

import java.util.List;

@Service
public class OrderProvider {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order){
        orderRepository.saveAndFlush(order);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getOrdersInArea(Float centerLatitude, Float centerLongitude, Float radius) {
        return orderRepository.findAllInArea(centerLatitude, centerLongitude, radius);
    }

    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderId);
    }
}
