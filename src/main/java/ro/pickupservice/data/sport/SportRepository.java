package ro.pickupservice.data.sport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.sport.entity.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer>{
	

}
