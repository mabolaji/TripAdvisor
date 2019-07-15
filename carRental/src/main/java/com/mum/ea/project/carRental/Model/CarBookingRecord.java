package com.mum.ea.project.carRental.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
public class CarBookingRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
@Column(name="renteEmail",nullable = false)
   private String email;
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="rentedCarId",nullable = false)
   private Car car;
   @Temporal(TemporalType.DATE)
   @Column(nullable=false)
   private Date pickdate;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
   private  Date dropDate;

    public CarBookingRecord(String email, Car car, Date pickdate, Date dropDate) {
        this.email = email;
        this.car = car;
        this.pickdate = pickdate;
        this.dropDate = dropDate;
    }
}
