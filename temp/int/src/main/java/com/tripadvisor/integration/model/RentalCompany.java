package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.List;

@Data

public class RentalCompany {

    private Long id;

    private String comapanyName;
    private String location;
    private String address;
    private List<Car> car;

    public RentalCompany(String comapanyName, String location, List<Car> car) {
        this.comapanyName = comapanyName;
        this.location = location;
        this.car = car;
    }
}
