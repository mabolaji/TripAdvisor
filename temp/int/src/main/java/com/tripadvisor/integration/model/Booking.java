package com.tripadvisor.integration.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Booking {
    @NotNull(message = "Kindly select origin")
    private Long originId;
    @NotNull(message = "Kindly select destination")
    private Long destinationId;
    @NotNull(message = "Kindly select valid departure date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Departure date must be a date in the future")
    private Date from;
   // @NotNull(message = "Kindly select valid return date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Departure date must be a date in the future")
    private Date to;
}

