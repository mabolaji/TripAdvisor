package com.tripadvisor.integration.model;

import lombok.Data;


@Data
public class FlightBook {
    private Long id;
    private String email;
    private Flight flight;

}
