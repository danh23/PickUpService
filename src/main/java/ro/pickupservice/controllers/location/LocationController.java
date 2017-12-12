package ro.pickupservice.controllers.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.pickupservice.controllers.location.bean.request.SetLocationRequest;
import ro.pickupservice.controllers.location.bean.response.LocationResponse;
import ro.pickupservice.services.location.LocationService;

@RestController
@RequestMapping(value = "/location", produces = "application/json")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "setLocation", method = RequestMethod.POST)
	public ResponseEntity<Long> setLocation (SetLocationRequest request) {
		locationService.setLocation(request); 
		return new ResponseEntity<>(request.getUser_id(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getLocation", method = RequestMethod.GET)
	public ResponseEntity<LocationResponse> getLocation(@RequestParam String userId) {
		LocationResponse locationResponse = locationService.getLocation(userId);
		return new ResponseEntity<>(locationResponse, HttpStatus.OK);
	}

}
