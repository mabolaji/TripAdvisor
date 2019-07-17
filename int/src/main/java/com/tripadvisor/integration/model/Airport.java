package com.tripadvisor.integration.model;

import lombok.Data;

@Data
public class Airport {
    private  Long id;
    private  String name;

    @Override
    public String toString() {
        return  name ;
    }
}
