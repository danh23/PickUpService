package ro.pickupservice.services.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ro.pickupservice.controllers.location.bean.request.SetLocationRequest;
import ro.pickupservice.controllers.location.bean.response.LocationResponse;
import ro.pickupservice.data.coordinates.CoordinatesRepository;
import ro.pickupservice.data.coordinates.entity.Coordinates;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.services.user.UserService;

@Service
@CacheConfig(cacheNames={"locations"})
public class LocationService {
	
	@Autowired
	private CoordinatesRepository coordinatesRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@CachePut(key="#request.userId")
	public void setLocation(SetLocationRequest request) {
		User user = userService.getUserById(request.getUserId());

		Coordinates coordinates = getCoordinates(request.getUserId());
		if(null == coordinates){
			coordinates = new Coordinates();
		}
		coordinates.setUser(user);
		coordinates.setLatitude(request.getLatitude());
		coordinates.setLongitude(request.getLongitude());
		user.setCoordinates(coordinates);
		coordinatesRepository.saveAndFlush(coordinates);
		userRepository.saveAndFlush(user);
	}
	

	public LocationResponse getLocation(Long userId) {
		LocationResponse response = new LocationResponse();
		Coordinates coordinates = getCoordinates(userId);
		response.setLatitude(coordinates.getLatitude());
		response.setLongitude(coordinates.getLongitude());
		return response;
	}

	@Cacheable
	private Coordinates getCoordinates(Long userId){
		return coordinatesRepository.findByUserId(userId);
	}

}
