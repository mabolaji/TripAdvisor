package com.tripadvisor.integration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
public class Airplanes {

    private  Long id;

    private String regestrationNo;

    private int seat;

    private Airlines airline;

    private List<Flight> flightList=new ArrayList();
}
