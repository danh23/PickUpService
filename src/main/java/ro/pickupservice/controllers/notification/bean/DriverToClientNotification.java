package ro.pickupservice.controllers.notification.bean;

import ro.pickupservice.bean.Location;
import ro.pickupservice.constants.NotificationScope;

public class DriverToClientNotification {

    private String topic;
    private NotificationScope scope;
    private String orderTitle;
    private Location driverLocation;
    private Long driverId;
    private Long orderId;
    private String estimatedTime;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public NotificationScope getScope() {
        return scope;
    }

    public void setScope(NotificationScope scope) {
        this.scope = scope;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public Location getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(Location driverLocation) {
        this.driverLocation = driverLocation;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
