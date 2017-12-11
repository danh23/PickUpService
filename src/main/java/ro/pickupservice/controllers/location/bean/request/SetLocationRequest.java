package ro.pickupservice.controllers.location.bean.request;

import ro.pickupservice.controllers.bean.BaseRequest;

public class SetLocationRequest extends BaseRequest{

	private static final long serialVersionUID = -795338880421504304L;
	
	private Long user_id;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "SetLocationRequest [user_id=" + user_id + "]";
	}
	
}
