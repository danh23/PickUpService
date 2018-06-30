package ro.pickupservice.data.driverSettings.entity;

import ro.pickupservice.bean.Dimensions;
import ro.pickupservice.bean.Location;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.user.entity.User;

import javax.persistence.*;

@Entity
public class DriverSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Location location;
    private Float radius;
    private Boolean takeFragile;
    @ManyToOne
    private CarType carType;
    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public Boolean getTakeFragile() {
        return takeFragile;
    }

    public void setTakeFragile(Boolean takeFragile) {
        this.takeFragile = takeFragile;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
