package com.mum.ea.project.carRental.listener;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Booking {

    private String email;
    private Long carId;
    private Date pickDate;
    private  Date dropDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }
}
