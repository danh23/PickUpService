package ro.pickupservice.controllers.location.bean.response;

import java.io.Serializable;

public class LocationResponse implements Serializable{

	private static final long serialVersionUID = 2481576516116919736L;
	
	private Float latitude;
	private Float longitude;
	
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LocationResponse [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
