package ro.pickupservice.data.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.order.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    public List<Order> findByUserId(Long userId);

    @Query(nativeQuery = true, value = "select * from ORDERS where SQRT(POWER(ABS(pick_up_latitude - ?1), 2) + POWER(ABS(pick_up_longitude - ?2), 2)) <= ?3")
    public List<Order> findAllInArea(float centerLatitude, float centerLongitude, float radius);
    //public List<Order> findAllByPickUpLatitudeLessThanEqualAndPickUpLatitudeGreaterThanEqualAndPickUpLongitudeLessThanEqualAndPickUpLongitudeGreaterThanEqual(float maxLatitude, float minLatitude, float maxLongitude, float minLongitude);
}
