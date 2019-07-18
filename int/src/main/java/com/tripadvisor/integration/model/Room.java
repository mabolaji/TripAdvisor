package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;


@Data

public class Room implements Serializable {
    private Long id;
    private int roomNo;
    private int beds;
    private double price;
    private int status;
    private String type;
    private Hotel hotel;

    @Override
    public String toString() {
        return
                "Room # =" + roomNo +
                ", Price =" + price +
                ", T ype='" + type ;
    }
}
