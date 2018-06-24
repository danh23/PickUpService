package ro.pickupservice.data.user.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import ro.pickupservice.data.location.entity.Location;
import ro.pickupservice.data.order.entity.Order;

@Entity
@Table(name="USERS")
public class User implements Serializable{

	private static final long serialVersionUID = -8787444391909479638L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(unique=true)
	private String username;

	private String password;

	@Column(unique=true)
	private String email;
	private String firstName;
	private String lastName;
	private String city;
	private String country;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Location location;

	@OneToMany(mappedBy = "user")
	private Set<Order> orders;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email +
				", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", country=" + country
				+ "]";
	}
	
}
