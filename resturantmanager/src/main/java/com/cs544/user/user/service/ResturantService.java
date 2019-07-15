package com.cs544.user.user.service;

import com.cs544.user.user.domain.Restaurant;
import com.cs544.user.user.repository.IResturantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class ResturantService implements IResturantService {

    @Autowired
    private IResturantRepository userRepository;

    @Override
    public List<Restaurant> getAll() {
        return userRepository.findAll();
    }
    @Override
    public Restaurant get(Integer id) {
        return userRepository.getOne(id);
    }
    @Override
    public Restaurant save(@NotNull @Valid Restaurant restaurant) {
        return userRepository.save(restaurant);
    }
}
