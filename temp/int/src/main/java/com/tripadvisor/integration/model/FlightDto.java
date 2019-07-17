package com.tripadvisor.integration.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class FlightDto {
    private String reg_num;
    private String flightNumber;
    private String arrival_city;
    private String departure_city;
    private LocalDate departure_date;
    private LocalDate arrival_date;

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String airLine;
    private Long Id;
}
