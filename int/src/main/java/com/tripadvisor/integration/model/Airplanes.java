package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Airplanes {
    private  Long id;

    private String regestrationNo;

    private int seat;

    private  Airlines airline;

    private List<Flight> flightList=new ArrayList();
}
