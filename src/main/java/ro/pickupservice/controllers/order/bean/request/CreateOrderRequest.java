package ro.pickupservice.controllers.order.bean.request;

import java.io.Serializable;
import java.util.Date;

import ro.pickupservice.data.user.entity.User;

public class CreateOrderRequest implements Serializable{
	
	private static final long serialVersionUID = -6513517704620169543L;
	
	private Long userId;
	private String pickUpLocation;
	private Float pickUpLatitude;
	private Float pickUpLongitude;
	private String dropOffLocation;
	private Float dropOffLatitude;
	private Float dropOffLongitude;
	private Date pickUpDate;
	private Date dropOffDate;
	private Boolean fragile;
	private Float length;
	private Float width;
	private Float height;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public Float getPickUpLatitude() {
		return pickUpLatitude;
	}

	public void setPickUpLatitude(Float pickUpLatitude) {
		this.pickUpLatitude = pickUpLatitude;
	}

	public Float getPickUpLongitude() {
		return pickUpLongitude;
	}

	public void setPickUpLongitude(Float pickUpLongitude) {
		this.pickUpLongitude = pickUpLongitude;
	}

	public String getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public Float getDropOffLatitude() {
		return dropOffLatitude;
	}

	public void setDropOffLatitude(Float dropOffLatitude) {
		this.dropOffLatitude = dropOffLatitude;
	}

	public Float getDropOffLongitude() {
		return dropOffLongitude;
	}

	public void setDropOffLongitude(Float dropOffLongitude) {
		this.dropOffLongitude = dropOffLongitude;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public Boolean getFragile() {
		return fragile;
	}

	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}
}
