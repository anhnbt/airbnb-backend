package com.codegym.airbnb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends AbstractEntity implements Serializable {
    private String name;
    private String description;
    private String address;
    @Column(name = "price_per_night")
    private Double pricePerNight;
    @Column(name = "total_of_bedroom")
    private Byte totalOfBedroom;
    @Column(name = "total_of_bathroom")
    private Byte totalOfBathroom;
    private Boolean status;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "room_id")
    private List<RoomImage> roomImages;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Booking> bookings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false, updatable = false)
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_type", nullable = false, updatable = false)
    private PropertyType propertyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Byte getTotalOfBedroom() {
        return totalOfBedroom;
    }

    public void setTotalOfBedroom(Byte totalOfBedroom) {
        this.totalOfBedroom = totalOfBedroom;
    }

    public Byte getTotalOfBathroom() {
        return totalOfBathroom;
    }

    public void setTotalOfBathroom(Byte totalOfBathroom) {
        this.totalOfBathroom = totalOfBathroom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public List<RoomImage> getRoomImages() {
        return roomImages;
    }

    public void setRoomImages(List<RoomImage> roomImages) {
        this.roomImages = roomImages;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
