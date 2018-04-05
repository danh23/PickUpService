package ro.pickupservice.data.driverSettings;

import ro.pickupservice.controllers.driver.bean.request.DriverSettingsRequest;
import ro.pickupservice.controllers.driver.bean.response.DriverSettingsDto;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;
import ro.pickupservice.data.user.entity.User;

public class DriverSettingsMapper {

    public static DriverSettings updateDriverSettingsRequestToDriverSettings(DriverSettings driverSettings, DriverSettingsRequest request, CarType carType, User user) {
        driverSettings.setLocation(request.getLocation());
        driverSettings.setTakeFragile(request.getTakeFragile());
        driverSettings.setCarType(carType);
        driverSettings.setUser(user);
        return driverSettings;
    }

    public static DriverSettingsDto mapDriverSettingsToDriverSettingsDto(DriverSettings driverSettings) {
        DriverSettingsDto driverSettingsDto = new DriverSettingsDto();
        driverSettingsDto.setCarType(driverSettings.getCarType());
        driverSettingsDto.setId(driverSettings.getId());
        driverSettingsDto.setLocation(driverSettings.getLocation());
        driverSettingsDto.setTakeFragile(driverSettings.getTakeFragile());
        driverSettingsDto.setUserId(driverSettings.getUser().getId());
        return driverSettingsDto;
    }
}
