package ro.pickupservice.data.order.entity;

import java.io.Serializable;
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
@Table(name="ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 4262495351450982647L;
	
	private Long order_id;
	private User user;
	private String pickUpLocation;
	private String dropOffLocation;
	private Date pickUpDate;
	private Boolean fragile;
	private Float length;
	private Float width;
	private Float height;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "id", unique = true, nullable = false)
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	@ManyToOne
    @JoinColumn(name = "user_id")
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

	public String getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
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
		return "Order [order_id=" + order_id + ", user=" + user + ", pickUpLocation=" + pickUpLocation
				+ ", dropOffLocation=" + dropOffLocation + ", pickUpDate=" + pickUpDate +
				", fragile=" + fragile + ", length=" + length + ", width=" + width + ", height=" + height + "]";
	}
	
}
