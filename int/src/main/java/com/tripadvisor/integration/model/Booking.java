package com.tripadvisor.integration.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Booking {
    private Long originId;
    private Long destinationId;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String from;
    private String to;
}

class BookingValid extends  Booking {

    private Long originId;
    private Long destinationId;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String from;
    private String to;
}