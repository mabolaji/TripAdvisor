package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Airlines {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name;

    private String country;

    private String city;

    @OneToMany(mappedBy = "airline",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Airplanes> airplane=new ArrayList();
}
