package ro.pickupservice.controllers.driver.bean.request;

import ro.pickupservice.bean.Dimensions;
import ro.pickupservice.bean.Location;

public class DriverSettings {

    private Long id;
    private Boolean takeFragile;
    private Dimensions dimensions;
    private Location location;

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

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
