package com.codegym.airbnb.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Home {
    private int id;
    private String name;
    private String description;
    private String address;
    private float pricePerNight;
    private byte numBedrooms;
    private byte numBathrooms;

    private List<Booking> bookings;
    private List<Image> images;
    private User user;
    private City city;
    private Roomtype roomtype;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


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


    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }


    public byte getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(byte numBedrooms) {
        this.numBedrooms = numBedrooms;
    }


    public byte getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(byte numBathrooms) {
        this.numBathrooms = numBathrooms;
    }


    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookingById) {
        this.bookings = bookingById;
    }

    @OneToMany(mappedBy = "home", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City cityByCityId) {
        this.city = cityByCityId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomtype_id", nullable = false)
    public Roomtype getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }
}
