package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookingDto implements Serializable {
    private String email;
    private Long flightId;
}