package com.project.tripadvisor.flightBooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Airplanes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String regestrationNo;

    @Email
    @Column(nullable = false)
    private String email;

    private int seat;

    @ManyToOne
    @JsonBackReference
    private  Airlines airline;

    @OneToMany(mappedBy = "airplane")
    @JsonManagedReference
    private List<Flight> flightList=new ArrayList();
}

