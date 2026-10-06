package com.ticket.reservation.domain;

import jakarta.persistence.*;
import java.lang.String;
import java.time.LocalDateTime;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat Seat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column()
    private ReservationStatus status;
    @Column()
    private LocalDateTime expires_at;
    @Column()
    private LocalDateTime created_at;

    public Reservation(){}

    public Reservation(Seat seat, User user, ReservationStatus status, LocalDateTime created_at) {
        Seat = seat;
        this.user = user;
        this.status = status;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public Seat getSeat() {
        return Seat;
    }

    public void setSeat(Seat seat) {
        Seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDateTime getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(LocalDateTime expires_at) {
        this.expires_at = expires_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
