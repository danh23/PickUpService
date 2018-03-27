package ro.pickupservice.data.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.order.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    public List<Order> findByUserId(Long userId);

    @Query(nativeQuery = true, value = "select * from ORDERS where pick_up_latitude BETWEEN ?1 AND ?2 AND pick_up_longitude BETWEEN ?3 AND ?4")
    public List<Order> findAllInArea(float minLatitude, float maxLatitude, float minLongitude, float maxLongitude);
    //public List<Order> findAllByPickUpLatitudeLessThanEqualAndPickUpLatitudeGreaterThanEqualAndPickUpLongitudeLessThanEqualAndPickUpLongitudeGreaterThanEqual(float maxLatitude, float minLatitude, float maxLongitude, float minLongitude);
}
