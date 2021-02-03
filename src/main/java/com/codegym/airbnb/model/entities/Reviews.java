package com.codegym.airbnb.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Reviews {
    private int id;
    private byte rating;
    private String reviewBody;
    private Byte status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Bookings booking;

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
    @Column(name = "rating")
    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "review_body")
    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings bookingsByBookingId) {
        this.booking = bookingsByBookingId;
    }
}
