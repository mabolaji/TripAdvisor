package com.tripadvisor.integration.model;

import lombok.Data;



@Data
public class Airport {

    private  Long id;

    private String name;

    private String country;

    private String city;

    private String airportCode;

//    @OneToMany(mappedBy = "departure")
//    @JsonManagedReference
//    private List<Flight> origin=new ArrayList();
//
//    @OneToMany(mappedBy = "arrival",fetch = FetchType.EAGER)
//    @JsonManagedReference
//    private List<Flight> destinition=new ArrayList();





}
