package ro.pickupservice.controllers.driver.bean.request;

import ro.pickupservice.bean.Dimensions;
import ro.pickupservice.bean.Location;

import javax.validation.constraints.NotNull;

public class DriverSettingsRequest {

    @NotNull
    private Long id;
    private Boolean takeFragile;
    private Location location;
    @NotNull
    private Long carTypeId;

    public Long getId() {
        return id;
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

    public Long getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }
}
