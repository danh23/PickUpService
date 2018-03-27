package ro.pickupservice.data.order.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import ro.pickupservice.bean.Location;
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
	private String title;
	private String pickUpAddress;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="latitude", column=@Column(name="pickUpLatitude")),
			@AttributeOverride(name="longitude", column=@Column(name="pickUpLongitude"))
	})
	private Location pickUpLocation;
	private String dropOffAddress;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="latitude", column=@Column(name="dropOffLatitude")),
			@AttributeOverride(name="longitude", column=@Column(name="dropOffLongitude"))
	})
	private Location dropOffLocation;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPickUpAddress() {
		return pickUpAddress;
	}

	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}

	public Location getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDropOffAddress() {
		return dropOffAddress;
	}

	public void setDropOffAddress(String dropOffAddress) {
		this.dropOffAddress = dropOffAddress;
	}

	public Location getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(Location dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
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
		return "Order [id=" + id + ", user=" + user + ", pickUpAddress=" + pickUpAddress
				+ ", dropOffAddress=" + dropOffAddress + ", pickUpDate=" + pickUpDate +
				", fragile=" + fragile + ", length=" + length + ", width=" + width + ", height=" + height + "]";
	}
}
