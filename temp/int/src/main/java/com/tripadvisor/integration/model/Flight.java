package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

//import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class Flight {
    private Long id;
    private String flightNumber;

    @ManyToOne
    private Airport departure;
    @ManyToOne
    private Airport arrival;

    private LocalDateTime departureDate;

    @ManyToOne
    private Airlines airlines;

    private LocalDateTime arrivalDate;
    @OneToMany
    @JoinColumn
    private List<FlightBook> flightBooks=new ArrayList();

    @ManyToOne
    private Airplanes airplane;
}
