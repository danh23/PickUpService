package ro.pickupservice.data.carType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.pickupservice.data.carType.entity.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long>{
}
