package ro.pickupservice.controllers.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.pickupservice.controllers.driver.bean.request.DriverSettingsRequest;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.services.carType.CarTypeService;
import ro.pickupservice.services.driver.DriverService;

import java.util.List;

@RestController
@RequestMapping(value = "/driver", produces = "application/json")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarTypeService carTypeService;

    @RequestMapping(value = "/updateSettings", method = RequestMethod.POST)
    public ResponseEntity<Long> updateSettings(@RequestBody DriverSettingsRequest request) {
        Long driverId = driverService.updateSettings(request);
        return new ResponseEntity<>(driverId, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCarTypes", method = RequestMethod.POST)
    public ResponseEntity<List<CarType>> getCarTypes() {
        List<CarType> response = carTypeService.getCarTypes();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
