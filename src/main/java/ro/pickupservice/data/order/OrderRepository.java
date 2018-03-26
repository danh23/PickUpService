package ro.pickupservice.data.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.order.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    public List<Order> findByUserId(Long userId);

    public List<Order> findAllByPickUpLatitudeLessThanEqualAndPickUpLatitudeGreaterThanEqualAndPickUpLongitudeLessThanEqualAndPickUpLongitudeGreaterThanEqual(float maxLatitude, float minLatitude, float maxLongitude, float minLongitude);
}
