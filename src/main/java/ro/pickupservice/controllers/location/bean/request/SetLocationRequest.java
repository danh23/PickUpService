package ro.pickupservice.controllers.location.bean.request;

import ro.pickupservice.controllers.bean.BaseRequest;

public class SetLocationRequest extends BaseRequest{

	private static final long serialVersionUID = -795338880421504304L;
	
	private Long user_id;
	private Float latitude;
	private Float longitude;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

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
		return "SetLocationRequest [user_id=" + user_id + "]";
	}
	
}
