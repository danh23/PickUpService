package ro.pickupservice.data.driverSettings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;

@Repository
public interface DriverSettingsRepository extends JpaRepository<DriverSettings, Long>{

    public DriverSettings findByUserId(Long userId);
}
