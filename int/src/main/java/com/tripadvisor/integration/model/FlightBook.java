package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Data
public class FlightBook {

    private Long id;
    private String email;
    private Flight flight;

}
