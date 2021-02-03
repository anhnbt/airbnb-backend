package com.codegym.airbnb.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    private int id;
    private String imageUrl;
    private Place place;

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
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place placeById) {
        this.place = placeById;
    }
}
