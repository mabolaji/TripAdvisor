package com.tripadvisor.integration.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Airlines {

    private  Long id;

    private String name;

    private String country;

    private String city;

    private List<Airplanes> airplane=new ArrayList();
}
