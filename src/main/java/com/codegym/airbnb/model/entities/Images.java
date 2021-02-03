package com.codegym.airbnb.model.entities;

import javax.persistence.*;

@Entity
@Table
public class Images {
    private int id;
    private String imageUrl;
    private Places place;

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
    public Places getPlace() {
        return place;
    }

    public void setPlace(Places placesById) {
        this.place = placesById;
    }
}
