package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.Date;

@Data
public class Booking {
    private  Long originId;
    private  Long destinationId;
    private Date from;
    
}
