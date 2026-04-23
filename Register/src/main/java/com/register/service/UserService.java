package com.register.service;

import com.register.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Long userId);

    public User updateUser(Long userId,User user);

    public String deleteUserById(Long userId);

}
