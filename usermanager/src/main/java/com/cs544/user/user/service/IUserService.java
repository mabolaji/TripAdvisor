package com.cs544.user.user.service;

import com.cs544.user.user.domain.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User getUser(String email);
    User save(User user);

}

