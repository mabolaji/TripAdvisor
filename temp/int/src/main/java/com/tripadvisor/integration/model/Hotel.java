package com.tripadvisor.integration.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class Hotel{
    private Long id;
    private String name;
    private String description;
    private String image;
    private String city;
    private List<Room> roooms = new ArrayList<>();



}
