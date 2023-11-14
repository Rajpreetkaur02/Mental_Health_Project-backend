package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User addUser(User user);

    public User getSpecificUser(String email);
}
