package com.mum.ea.project.carRental.Model;

import lombok.Data;

@Data
public class CarDTO {
    private String carBrand;
    private String carName;
    private String imageurl;
    private  int seatingCapacity;
    private double price;
    private String carTransmissiontype;
    private String compLocation;
}
