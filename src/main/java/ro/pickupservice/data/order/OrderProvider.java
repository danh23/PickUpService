package ro.pickupservice.data.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.order.entity.Order;

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
}
