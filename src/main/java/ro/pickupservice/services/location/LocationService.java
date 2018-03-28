package ro.pickupservice.services.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ro.pickupservice.controllers.location.bean.request.SetLocationRequest;
import ro.pickupservice.controllers.location.bean.response.LocationResponse;
import ro.pickupservice.data.location.LocationRepository;
import ro.pickupservice.data.location.entity.Location;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.services.user.UserService;

@Service
@CacheConfig(cacheNames={"locations"})
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@CachePut(key="#request.userId")
	public void setLocation(SetLocationRequest request) {
		User user = userService.getUserById(request.getUserId());

		Location location = getCoordinates(request.getUserId());
		if(null == location){
			location = new Location();
		}
		location.setUser(user);
		location.setLatitude(request.getLatitude());
		location.setLongitude(request.getLongitude());
		user.setLocation(location);
		locationRepository.saveAndFlush(location);
		userRepository.saveAndFlush(user);
	}
	

	public LocationResponse getLocation(Long userId) {
		LocationResponse response = new LocationResponse();
		Location coordinates = getCoordinates(userId);
		response.setLatitude(coordinates.getLatitude());
		response.setLongitude(coordinates.getLongitude());
		return response;
	}

	@Cacheable
	private Location getCoordinates(Long userId){
		return locationRepository.findByUserId(userId);
	}

}
