package com.cs544.controller;

import com.cs544.service.ResturantService;
import com.cs544.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    ResturantService userService;

    @GetMapping
    public List<Restaurant> get() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @PostMapping
    public Restaurant save(@RequestBody @Valid @NotNull Restaurant restaurant) {

        Restaurant _restaurant = get(restaurant.getId());

        if (_restaurant != null) {
            restaurant.setId(_restaurant.getId());
        }

        return userService.save(restaurant);

    }

}
