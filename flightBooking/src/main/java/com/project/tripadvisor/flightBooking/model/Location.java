package com.project.tripadvisor.flightBooking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false)
    private  String name;
   //private  String code;
}
