package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Appointments;
import com.MentalHealthProject.mentalHealth.entities.CommunityPosts;
import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
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

    @GetMapping("/{id}")
    public Therapist getSpecificTherapist(@PathVariable String id) {
        return this.therapistService.getSpecificTherapist(id);
    }

    @GetMapping("/getAppointments/{id}")
    public List<Appointments> getPosts(@PathVariable String id) {
        return this.therapistService.getAppointments(id);
    }

    @PutMapping("/updateAppointment/{therapistId}")
    public Therapist updateTherapist(@PathVariable String therapistId, @RequestBody String timestamp) {
        return this.therapistService.updateTherapist(therapistId, timestamp);
    }
}
