package com.cs544.user.user.controller;

import com.cs544.user.user.domain.User;
import com.cs544.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> get() {
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User get(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping
    public User save(@RequestBody @Valid @NotNull User user) {

        User _user = get(user.getEmail());

        if (_user != null) {
            user.setId(_user.getId());
        }

        return userService.save(user);

    }

}
