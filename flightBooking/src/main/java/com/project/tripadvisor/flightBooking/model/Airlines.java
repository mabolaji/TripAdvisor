package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Airlines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    @OneToMany(mappedBy = "airlines")
    @JsonManagedReference
    private List<Flight> flightList;

    @OneToMany(mappedBy = "airline")
    @JsonManagedReference
    private List<Airplanes> airplanes;


}
