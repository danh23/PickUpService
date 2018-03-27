package ro.pickupservice.data.driverSettings;

import ro.pickupservice.controllers.driver.bean.request.DriverSettingsRequest;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;

public class DriverSettingsMapper {

    public static DriverSettings updateDriverSettingsRequestToDriverSettings(DriverSettings driverSettings, DriverSettingsRequest request, CarType carType) {
        driverSettings.setLocation(request.getLocation());
        driverSettings.setTakeFragile(request.getTakeFragile());
        driverSettings.setCarType(carType);
        return driverSettings;
    }
}
