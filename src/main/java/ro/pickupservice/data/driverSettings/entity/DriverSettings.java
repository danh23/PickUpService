package ro.pickupservice.data.driverSettings.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float latitude;
    private Float longitude;
    private Float width;
    private Float height;
    private Float length;
    private Boolean takeFragile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Boolean getTakeFragile() {
        return takeFragile;
    }

    public void setTakeFragile(Boolean takeFragile) {
        this.takeFragile = takeFragile;
    }
}
