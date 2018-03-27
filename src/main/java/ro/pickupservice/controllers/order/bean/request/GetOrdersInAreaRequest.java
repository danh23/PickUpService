package ro.pickupservice.controllers.order.bean.request;

import ro.pickupservice.bean.Location;

public class GetOrdersInAreaRequest {

    private Location location;
    private Float offset;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float getOffset() {
        return offset;
    }

    public void setOffset(Float offset) {
        this.offset = offset;
    }
}
