package com.codegym.airbnb.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {
    private int id;
    private String name;
    private String description;
    private String address;
    private float pricePerNight;
    private byte numBedrooms;
    private byte numBathrooms;

    private List<Booking> bookings;
    private List<Image> images;
    private Host host;
    private City city;
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "price_per_night")
    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Basic
    @Column(name = "num_bedrooms")
    public byte getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(byte numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    @Basic
    @Column(name = "num_bathrooms")
    public byte getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(byte numBathrooms) {
        this.numBathrooms = numBathrooms;
    }



    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookingById) {
        this.bookings = bookingById;
    }

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> imageById) {
        this.images = imageById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", referencedColumnName = "id", nullable = false)
    public Host getHost() {
        return host;
    }

    public void setHost(Host hostByHostId) {
        this.host = hostByHostId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City cityByCityId) {
        this.city = cityByCityId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryByCategoryId) {
        this.category = categoryByCategoryId;
    }
}
