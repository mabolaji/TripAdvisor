package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @ManyToOne
    @JsonBackReference
    private Flight flight;

}
