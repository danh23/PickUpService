package ro.pickupservice.controllers.order.bean.response;

import ro.pickupservice.bean.Location;

public class OrderSummary {

    private Long id;
    private String title;
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
