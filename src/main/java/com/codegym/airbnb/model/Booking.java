package com.codegym.airbnb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking extends AbstractEntity implements Serializable {
    @Column(name = "number_of_guests")
    private Byte numberOfGuests;

    @Column(name = "number_of_children")
    private Byte numberOfChildren;

    @Column(name = "number_of_infants")
    private Byte numberOfInfants;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 15)
    private BookingStatus status;

    @Column(name = "cancel_reservation_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime cancelReservationTime;

//    @Transient
//    private int numNight;

    // fetch = FetchType.LAZY khi select đối tượng Booking thì mặc định không query các đối tượng User liên quan.
    // CascadeType.ALL Tương ứng với tất cả các loại cascade. cascade={DETACH, MERGE, PERSIST, REFRESH, REMOVE}
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    @JsonIgnore
    private UserModel user;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
//    @JsonIgnore
    private Room room;

    public Byte getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Byte numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Byte getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Byte numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Byte getNumberOfInfants() {
        return numberOfInfants;
    }

    public void setNumberOfInfants(Byte numberOfInfants) {
        this.numberOfInfants = numberOfInfants;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDateTime getCancelReservationTime() {
        return cancelReservationTime;
    }

    public void setCancelReservationTime(LocalDateTime cancelReservationTime) {
        this.cancelReservationTime = cancelReservationTime;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

//    public int getNumNight() {
//        return this.endDate.getDayOfMonth() - this.startDate.getDayOfMonth();
//    }

//    public void setNumNight(int numNight) {
//        this.numNight = numNight;
//    }
}
