package com.tripadvisor.integration.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class Flight {

    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private List<FlightBook> flightBooks=new ArrayList();
    private Airplanes airplane;
}
