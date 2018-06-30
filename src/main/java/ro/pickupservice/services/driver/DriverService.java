package ro.pickupservice.services.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.bean.Location;
import ro.pickupservice.controllers.driver.bean.request.DriverSettingsRequest;
import ro.pickupservice.controllers.driver.bean.response.DriverSettingsDto;
import ro.pickupservice.controllers.user.bean.response.UserDto;
import ro.pickupservice.data.carType.CarTypeProvider;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.driverSettings.DriverSettingsMapper;
import ro.pickupservice.data.driverSettings.DriverSettingsProvider;
import ro.pickupservice.data.driverSettings.entity.DriverSettings;
import ro.pickupservice.data.user.UserMapper;
import ro.pickupservice.data.user.UserProvider;
import ro.pickupservice.data.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DriverService {

    @Autowired
    private DriverSettingsProvider driverSettingsProvider;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private CarTypeProvider carTypeProvider;

    public Long updateSettings(DriverSettingsRequest request) {
        DriverSettings driverSettings = driverSettingsProvider.getDriverSettingsById(request.getId());
        if(null == driverSettings){
            driverSettings = new DriverSettings();
        }
        User user = userProvider.findUserById(request.getUserId());
        CarType carType = carTypeProvider.getCarTypeById(request.getCarTypeId());
        driverSettings = DriverSettingsMapper.updateDriverSettingsRequestToDriverSettings(driverSettings, request, carType, user);
        driverSettings.setId(driverSettingsProvider.saveDriverSettings(driverSettings).getId());
        return driverSettings.getId();
    }

    public DriverSettingsDto getSettingsByUserId(Long userId) {
        DriverSettings driverSettings = driverSettingsProvider.getDriverSettingsByUserId(userId);
        DriverSettingsDto response = DriverSettingsMapper.mapDriverSettingsToDriverSettingsDto(driverSettings);
        return response;
    }

    public List<UserDto> findDriversInArea(Location location) {
        List<DriverSettings> driverSettingsList = driverSettingsProvider.findAllInArea(location);
        List<UserDto> userDtos = driverSettingsList.stream().map(ds ->
                UserMapper.mapUserToUserDto(ds.getUser())
            ).collect(Collectors.toList());
        return userDtos;
    }
}
