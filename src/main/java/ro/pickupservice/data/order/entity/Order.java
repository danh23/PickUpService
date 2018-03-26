package ro.pickupservice.data.order.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ro.pickupservice.data.user.entity.User;

@Entity
@Table(name="ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 4262495351450982647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String pickUpLocation;
	private Float pickUpLatitude;
	private Float pickUpLongitude;
	private String dropOffLocation;
	private Float dropOffLatitude;
	private Float dropOffLongitude;
	private LocalDate dropOffDate;
	private LocalDate pickUpDate;
	private Boolean fragile;
	private Float length;
	private Float width;
	private Float height;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public LocalDate getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(LocalDate dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public LocalDate getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", pickUpLocation=" + pickUpLocation
				+ ", dropOffLocation=" + dropOffLocation + ", pickUpDate=" + pickUpDate +
				", fragile=" + fragile + ", length=" + length + ", width=" + width + ", height=" + height + "]";
	}
}
