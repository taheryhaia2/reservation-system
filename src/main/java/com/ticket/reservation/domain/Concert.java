package com.ticket.reservation.domain;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime hour;
    @Column(name= "number_of_places", nullable = false)
    private int numberOfPlaces;
    protected Concert() {} // JPA

    public Concert(String name, LocalDate date, LocalTime hour, int numberOfPlaces) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.numberOfPlaces = numberOfPlaces;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }
}
