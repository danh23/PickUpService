package ro.pickupservice.data.driverSettings.entity;

import ro.pickupservice.bean.Location;
import ro.pickupservice.data.carType.entity.CarType;

import javax.persistence.*;

@Entity
public class DriverSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Location location;
    private Boolean takeFragile;
    @ManyToOne
    private CarType carType;

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
}
