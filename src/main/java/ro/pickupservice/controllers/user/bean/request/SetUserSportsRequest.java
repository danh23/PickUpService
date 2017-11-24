package ro.pickupservice.controllers.user.bean.request;

import java.util.List;

import ro.pickupservice.controllers.bean.BaseRequest;
import ro.pickupservice.data.sport.entity.Sport;

public class SetUserSportsRequest extends BaseRequest {

	private static final long serialVersionUID = -7286426200865797779L;
	
	private Long userId;
	private List<Sport> sports;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long id) {
		this.userId = id;
	}
	public List<Sport> getSports() {
		return sports;
	}
	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	@Override
	public String toString() {
		return "SetUserSportsRequest [id=" + userId + ", sports=" + sports + "]";
	}
}
