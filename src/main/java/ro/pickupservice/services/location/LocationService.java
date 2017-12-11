package ro.pickupservice.services.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pickupservice.controllers.location.bean.request.SetLocationRequest;
import ro.pickupservice.controllers.location.bean.response.LocationResponse;
import ro.pickupservice.data.coordinates.CoordinatesRepository;

@Service
public class LocationService {
	
	@Autowired
	private CoordinatesRepository coordinatesRepository;
	
	public LocationResponse setLocation(SetLocationRequest request) {
		LocationResponse response = new LocationResponse();
		
		return response;
	}
	
	public LocationResponse getLocation(SetLocationRequest request) {
		LocationResponse response = new LocationResponse();
		
		return response;
	}

}
