package ro.pickupservice.controllers.driver.bean.response;

import ro.pickupservice.bean.Location;
import ro.pickupservice.data.carType.entity.CarType;
import ro.pickupservice.data.user.entity.User;

import javax.persistence.*;

public class DriverSettingsDto {

    private Long id;
    private Location location;
    private Boolean takeFragile;
    private CarType carType;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
