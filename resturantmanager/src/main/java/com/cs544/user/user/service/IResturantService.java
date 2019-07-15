package com.cs544.user.user.service;

import com.cs544.user.user.domain.Restaurant;

import java.util.List;

public interface IResturantService {
    List<Restaurant> getAll();
    Restaurant get(Integer id);
    Restaurant save(Restaurant restaurant);

}

