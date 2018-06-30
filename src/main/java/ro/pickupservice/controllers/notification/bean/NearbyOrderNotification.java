package ro.pickupservice.controllers.notification.bean;

import ro.pickupservice.bean.Location;

public class NearbyOrderNotification {

    private Long orderId;
    private Location location;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
