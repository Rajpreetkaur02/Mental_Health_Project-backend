package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import com.MentalHealthProject.mentalHealth.services.UserExtraDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extra")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExtraDetailsController {
    @Autowired
    private UserExtraDetailsService userExtraDetailsService;

    @PostMapping("/addDetails")
    public UserExtraDetails addDetails(@RequestBody UserExtraDetails userExtraDetails) {
        return this.userExtraDetailsService.addDetails(userExtraDetails);
    }

    @GetMapping("/getMood/{userId}")
    public List<Mood> getMood(@PathVariable String userId) {
        return this.userExtraDetailsService.getMood(userId);
    }

    @PutMapping(value = "/addMood/{userId}")
    public UserExtraDetails addMood(@PathVariable String userId, @RequestBody Mood userMood) {
        return this.userExtraDetailsService.addMood(userId, userMood);
    }
}
