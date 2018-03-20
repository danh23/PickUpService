package ro.pickupservice.controllers.location.bean.request;

import ro.pickupservice.controllers.bean.BaseRequest;

public class SetLocationRequest extends BaseRequest{

	private static final long serialVersionUID = -795338880421504304L;
	
	private Long userId;
	private Float latitude;
	private Float longitude;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long user_id) {
		this.userId = user_id;
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
		return "SetLocationRequest [user_id=" + userId + "]";
	}
	
}
