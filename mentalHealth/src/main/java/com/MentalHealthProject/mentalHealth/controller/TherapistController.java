package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Therapist;
import com.MentalHealthProject.mentalHealth.services.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapists")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TherapistController {
    @Autowired
    private TherapistService therapistService;

    @GetMapping("/")
    public List<Therapist> getTherapists() {
        return this.therapistService.getTherapists();
    }

    @PutMapping("/updateAppointment/{therapistId}")
    public Therapist updateTherapist(@PathVariable String therapistId, @RequestBody String timestamp) {
        return this.therapistService.updateTherapist(therapistId, timestamp);
    }
}
