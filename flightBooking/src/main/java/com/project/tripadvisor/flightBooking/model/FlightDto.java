package com.project.tripadvisor.flightBooking.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class FlightDto {
    private String reg_num;
    private String flightNumber;
    private String arrival_city;
    private String departure_city;
    private LocalDateTime departure_date;
    private LocalDateTime arrival_date;
    private String airLine;
    private Long Id;
}
