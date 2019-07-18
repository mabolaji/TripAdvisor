package com.tripadvisor.integration.model;

import lombok.Data;

@Data
public class CarDTO {
    private long id;
    private String carBrand;
    private String carName;
    private String imageurl;
    private  int seatingCapacity;
    private double price;
    private String carTransmissiontype;
    private String compLocation;
}
