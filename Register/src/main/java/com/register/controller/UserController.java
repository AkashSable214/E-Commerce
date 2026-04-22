package com.register.controller;

import com.register.model.User;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/userApi/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);

    }
}
