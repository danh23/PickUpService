package ro.pickupservice.data.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.location.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

    public Location findByUserId(Long userId);
}
