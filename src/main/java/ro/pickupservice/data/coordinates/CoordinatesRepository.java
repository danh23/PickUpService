package ro.pickupservice.data.coordinates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.coordinates.entity.Coordinates;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Long>{

}
