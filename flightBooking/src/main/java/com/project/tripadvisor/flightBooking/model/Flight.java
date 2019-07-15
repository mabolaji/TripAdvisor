package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;
    @OneToMany(mappedBy = "flight",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<FlightBook> flightBooks=new ArrayList();

    @ManyToOne
    @JsonBackReference
    private Airplanes airplane;
}
