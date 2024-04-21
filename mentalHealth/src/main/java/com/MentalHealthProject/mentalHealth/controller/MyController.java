package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.User;
import com.MentalHealthProject.mentalHealth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(value = "/updateUser/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        return this.userService.updateUser(email, user);
    }

    @GetMapping("/age/{email}")
    public String getAge(@PathVariable String email) {
        return this.userService.getAge(email);
    }

    @PutMapping(value = "/addSubscription/{email}")
    public User addSubscription(@PathVariable String email, @RequestBody String subscription) {
        return this.userService.addSubscription(email, subscription);
    }

    @GetMapping("/getSubscription/{email}")
    public String getSubscription(@PathVariable String email) {
        return this.userService.getSubscription(email);
    }
}
