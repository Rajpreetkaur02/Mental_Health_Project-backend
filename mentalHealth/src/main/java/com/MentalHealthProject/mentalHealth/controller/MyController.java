package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.EmergencyContact;
import com.MentalHealthProject.mentalHealth.entities.User;
import com.MentalHealthProject.mentalHealth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @GetMapping("/{email}")
    public User getSpecificUser(@PathVariable String email) {
        return this.userService.getSpecificUser(email);
    }
}
