package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class Flight {
    private Long id;
    private String flightNumber;

    private Airport departure;

    private Airport arrival;

    private LocalDateTime departureDate;

    private Airlines airlines;

    private LocalDateTime arrivalDate;

    private List<FlightBook> flightBooks=new ArrayList();

       private Airplanes airplane;
}
