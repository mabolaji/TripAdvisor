package com.tripadvisor.integration.model;

import lombok.Data;

public class Airport {
    private  Long id;
    private  String name;

    @Override
    public String toString() {
        return  name ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
