package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String city;

    private String airportCode;


    @OneToMany(mappedBy = "departure")
    @JsonManagedReference
    private List<Flight> origin=new ArrayList();

    @OneToMany(mappedBy = "arrival")
    @JsonManagedReference
    private List<Flight> origin1=new ArrayList();




}
