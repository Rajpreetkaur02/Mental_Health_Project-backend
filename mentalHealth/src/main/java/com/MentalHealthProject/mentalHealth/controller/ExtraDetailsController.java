package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import com.MentalHealthProject.mentalHealth.services.UserExtraDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
