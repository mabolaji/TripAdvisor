package com.cs544.service;

import com.cs544.domain.User;
import com.cs544.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUser(String email) {
        return userRepository.getUserByEmail(email);
    }
    @Override
    public User save(@NotNull @Valid User user) {
        return userRepository.save(user);
    }
}
