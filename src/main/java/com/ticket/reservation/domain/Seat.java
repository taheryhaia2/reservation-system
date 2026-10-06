package com.ticket.reservation.domain;
import jakarta.persistence.*;
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;
    @Column(name = "seat_number", nullable = false)
    private int seatNumber;
    protected Seat(){};

    public Seat(Concert concert, int seatNumber) {
        this.concert = concert;
        this.seatNumber = seatNumber;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Long getId() {
        return id;
    }



    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


}
