package com.codegym.airbnb.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Review {
    private int id;
    private byte rating;
    private String reviewBody;
    private Byte status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Booking booking;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
