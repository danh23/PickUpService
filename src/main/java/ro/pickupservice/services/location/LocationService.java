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

@Service
@CacheConfig(cacheNames={"locations"})
public class LocationService {
	
	@Autowired
	private CoordinatesRepository coordinatesRepository;
	
	@CachePut(key="#request.user_id")
	public void setLocation(SetLocationRequest request) {
		Coordinates coordinates = new Coordinates();
		coordinates.setId(request.getUser_id());
		coordinates.setLatitude(request.getLatitude());
		coordinates.setLongitude(request.getLongitude());
		coordinates = coordinatesRepository.saveAndFlush(coordinates);
	}
	
	@Cacheable
	public LocationResponse getLocation(String userId) {
		LocationResponse response = new LocationResponse();
		response.setLatitude(null);
		response.setLongitude(null);
		return response;
	}

}
