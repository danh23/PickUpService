package ro.pickupservice.controllers.order.bean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import ro.pickupservice.data.user.entity.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class OrderDto implements Serializable {

    private Long id;
    private String pickUpLocation;
    private Float pickUpLatitude;
    private Float pickUpLongitude;
    private String dropOffLocation;
    private Float dropOffLatitude;
    private Float dropOffLongitude;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EET")
    private LocalDate dropOffDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EET")
    private LocalDate pickUpDate;
    private Boolean fragile;
    private Float length;
    private Float width;
    private Float height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Float getPickUpLatitude() {
        return pickUpLatitude;
    }

    public void setPickUpLatitude(Float pickUpLatitude) {
        this.pickUpLatitude = pickUpLatitude;
    }

    public Float getPickUpLongitude() {
        return pickUpLongitude;
    }

    public void setPickUpLongitude(Float pickUpLongitude) {
        this.pickUpLongitude = pickUpLongitude;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public Float getDropOffLatitude() {
        return dropOffLatitude;
    }

    public void setDropOffLatitude(Float dropOffLatitude) {
        this.dropOffLatitude = dropOffLatitude;
    }

    public Float getDropOffLongitude() {
        return dropOffLongitude;
    }

    public void setDropOffLongitude(Float dropOffLongitude) {
        this.dropOffLongitude = dropOffLongitude;
    }

    public LocalDate getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDate dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Boolean getFragile() {
        return fragile;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
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
}
