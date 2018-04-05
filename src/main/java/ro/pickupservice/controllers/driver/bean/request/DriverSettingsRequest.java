package ro.pickupservice.controllers.driver.bean.request;

import ro.pickupservice.bean.Dimensions;
import ro.pickupservice.bean.Location;

import javax.validation.constraints.NotNull;

public class DriverSettingsRequest {

    @NotNull
    private Long id;
    private Long userId;
    private Boolean takeFragile;
    private Location location;
    private Dimensions dimensions;
    private Float weight;
    @NotNull
    private Long carTypeId;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTakeFragile() {
        return takeFragile;
    }

    public void setTakeFragile(Boolean takeFragile) {
        this.takeFragile = takeFragile;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Long getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }
}
