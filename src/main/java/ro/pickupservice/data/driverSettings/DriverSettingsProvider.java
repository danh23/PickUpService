package ro.pickupservice.data.driverSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;

@Service
public class DriverSettingsProvider {

    @Autowired
    private DriverSettingsRepository driverSettingsRepository;

    public DriverSettings getDriverSettingsById(Long id) {
        return driverSettingsRepository.findOne(id);
    }
}
