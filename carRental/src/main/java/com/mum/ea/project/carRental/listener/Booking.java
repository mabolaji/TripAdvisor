package com.mum.ea.project.carRental.listener;

import java.util.Date;

public class Booking {
    private String email;
    private Long carId;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "Booking{" +
                "email='" + email + '\'' +
                ", carId=" + carId +
                '}';
    }

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
