package ro.pickupservice.controllers.location.bean.response;

import java.io.Serializable;

public class LocationResponse implements Serializable{

	private static final long serialVersionUID = 2481576516116919736L;
	
	private Long latitude;
	private Long longitude;
	
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "LocationResponse [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
