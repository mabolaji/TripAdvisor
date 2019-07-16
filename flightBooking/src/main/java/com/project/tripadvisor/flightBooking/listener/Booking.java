package com.project.tripadvisor.flightBooking.listener;

public class Booking {
    private String email;
    private Long flightId;

    @Override
    public String toString() {
        return "Booking{" +
                "email='" + email + '\'' +
                ", flightId=" + flightId +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
