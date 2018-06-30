package ro.pickupservice.data.driverSettings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;
import ro.pickupservice.data.user.entity.User;

import java.util.List;

@Repository
public interface DriverSettingsRepository extends JpaRepository<DriverSettings, Long>{

    public DriverSettings findByUserId(Long userId);

    @Query(nativeQuery = true, value="select * FROM DRIVER_SETTINGS WHERE SQRT(POWER(ABS(latitude - ?1), 2) + POWER(ABS(longitude - ?2), 2)) <= radius")
    public List<DriverSettings> findAllDriversInArea(Float latitude, Float longitude);
}
