package com.cs544.service;

import com.cs544.domain.Restaurant;

import java.util.List;

public interface IResturantService {
    List<Restaurant> getAll();
    Restaurant get(Integer id);
    Restaurant save(Restaurant restaurant);

}

