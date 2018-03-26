package ro.pickupservice.controllers.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.pickupservice.controllers.driver.bean.request.DriverSettings;
import ro.pickupservice.services.driver.DriverService;

@RestController
@RequestMapping(value = "/driver", produces = "application/json")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/updateSettings", method = RequestMethod.POST)
    public ResponseEntity<Long> updateSettings(@RequestBody DriverSettings request) {
        Long driverId = driverService.updateSettings(request);
        return new ResponseEntity<>(driverId, HttpStatus.OK);
    }
}
