package ro.pickupservice.services.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.controllers.driver.bean.request.DriverSettingsRequest;
import ro.pickupservice.data.carType.CarTypeProvider;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.driverSettings.DriverSettingsMapper;
import ro.pickupservice.data.driverSettings.DriverSettingsProvider;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;

@Service
public class DriverService {

    @Autowired
    private DriverSettingsProvider driverSettingsProvider;

    @Autowired
    private CarTypeProvider carTypeProvider;

    public Long updateSettings(DriverSettingsRequest request) {
        DriverSettings driverSettings = driverSettingsProvider.getDriverSettingsById(request.getId());
        CarType carType = carTypeProvider.getCarTypeById(request.getCarTypeId());
        driverSettings = DriverSettingsMapper.updateDriverSettingsRequestToDriverSettings(driverSettings, request, carType);
        return driverSettings.getId();
    }
}
