package com.mum.ea.project.carRental.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
//@NoArgsConstructor
public class RentalCompany {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,length = 50,unique = true)
    private String comapanyName;
    @Column(nullable = false)
    private String location;
    private String address;
    @OneToMany(mappedBy = "rentalComp",fetch= FetchType.EAGER)
    @JsonManagedReference
    private List<Car> car;

    public RentalCompany(){}
    public RentalCompany(String comapanyName, String location, List<Car> car) {
        this.comapanyName = comapanyName;
        this.location = location;
        this.car = car;
    }
}
