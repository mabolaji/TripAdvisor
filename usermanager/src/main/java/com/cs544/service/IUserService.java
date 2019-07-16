package com.cs544.service;

import com.cs544.domain.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User getUser(String email);
    User save(User user);

}

