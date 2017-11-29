package ro.pickupservice.data.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
