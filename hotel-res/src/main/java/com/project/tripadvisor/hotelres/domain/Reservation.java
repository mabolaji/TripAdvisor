package com.project.tripadvisor.hotelres.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private LocalDate checkIn;
    private LocalDate checkOut;
    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

    public Reservation(String email, LocalDate checkIn, LocalDate checkOut, Room room) {
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
    }
}
