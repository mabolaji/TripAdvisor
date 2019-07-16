package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;


@Data

public class Room implements Serializable {
    private Long id;
    private int roomNo;
    private int beds;
    private double price;
    private int status;
    private Hotel hotel;
}
