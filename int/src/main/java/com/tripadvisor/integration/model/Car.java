package com.tripadvisor.integration.model;

import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.List;

@Data

public class Car {

    private Long id;

    private String carName;

    private String brand;
    private String plate;
    private boolean status;
    private String imageurl;

    private int seatingCapacity;

    private double price;

    private String carTransmissiontype;

    private List<CarBookingRecord> carbookinglist;
private RentalCompany rentalComp;

    public Car(String carName, String brand, boolean status, String imageurl, int seatingCapacity, @Positive double price, String carTransmissiontype, List<CarBookingRecord> carbookinglist, RentalCompany rentalComp) {
        this.carName = carName;
        this.brand = brand;
        this.status = status;
        this.imageurl = imageurl;
        this.seatingCapacity = seatingCapacity;
        this.price = price;
        this.carTransmissiontype = carTransmissiontype;
        this.carbookinglist = carbookinglist;
        this.rentalComp = rentalComp;
    }
}
