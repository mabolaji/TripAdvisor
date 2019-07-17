package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class Reservation implements Serializable {
    private Long id;
    private String email;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Room room;

    public Reservation(String email, LocalDate checkIn, LocalDate checkOut, Room room) {
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
    }
}
