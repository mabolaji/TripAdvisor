package com.project.tripadvisor.flightBooking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    /*
    @OneToMany(mappedBy = "departure")
    @JsonManagedReference
    private List<Flight> origin=new ArrayList();

    @OneToMany(mappedBy = "arrival",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Flight> destinition=new ArrayList();

*/


}
