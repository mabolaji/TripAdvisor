package com.mum.ea.project.carRental.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String carName;
    @Column(name = "carBrand", nullable = false)
    private String brand;
    @Column(nullable = false)
    private boolean status;
    private String imageurl;
    @Column(nullable = false)
    private int seatingCapacity;
    @Positive
    private double price;
    @Column(nullable = false)
    private String carTransmissiontype;
    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<CarBookingRecord> carbookinglist;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "companyId", nullable = false)
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
