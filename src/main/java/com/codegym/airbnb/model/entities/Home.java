package com.codegym.airbnb.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Home {
    private int id;

    @NotEmpty(message = "Cannot be empty")
    @UniqueElements(message = "This account existed !")
    @Size(max = 24)
    private String name;

    private String description;

    @NotEmpty(message = "Cannot be empty")
    @Size(max = 200)
    private String address;

    @NotEmpty(message = "Cannot be empty")
    @Min(value = 1)
    private float pricePerNight;

    @NotEmpty(message = "Cannot be empty")
    @Min(value = 1)
    private byte numBedrooms;

    @NotEmpty(message = "Cannot be empty")
    @Min(value = 1)
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


    @OneToMany(mappedBy = "home")
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookingById) {
        this.bookings = bookingById;
    }

    @OneToMany(mappedBy = "home")
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City cityByCityId) {
        this.city = cityByCityId;
    }

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "roomtype_id")
    public Roomtype getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }
}
