package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;

    @ManyToOne
    @JsonBackReference
    private Airport departure;
    @ManyToOne
    @JsonBackReference
    private Airport arrival;

    private LocalDateTime departureDate;

    @ManyToOne
    @JsonBackReference
    private Airlines airlines;

    private LocalDateTime arrivalDate;
    @OneToMany
    @JoinColumn
    @JsonManagedReference
    private List<FlightBook> flightBooks=new ArrayList();

    @ManyToOne
    @JsonBackReference
    private Airplanes airplane;
}
