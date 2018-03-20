package ro.pickupservice.controllers.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.pickupservice.controllers.location.bean.request.SetLocationRequest;
import ro.pickupservice.controllers.location.bean.response.LocationResponse;
import ro.pickupservice.services.location.LocationService;

@RestController
@RequestMapping(value = "/location", produces = "application/json")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "setLocation", method = RequestMethod.POST)
	public ResponseEntity<Long> setLocation (@RequestBody SetLocationRequest request) {
		locationService.setLocation(request); 
		return new ResponseEntity<>(request.getUserId(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getLocation/{userId}", method = RequestMethod.GET)
	public ResponseEntity<LocationResponse> getLocation(@PathVariable Long userId) {
		LocationResponse locationResponse = locationService.getLocation(userId);
		return new ResponseEntity<>(locationResponse, HttpStatus.OK);
	}

}
