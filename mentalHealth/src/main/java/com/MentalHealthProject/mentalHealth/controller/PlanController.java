package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Plan;
import com.MentalHealthProject.mentalHealth.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping("/")
    public List<Plan> getPlans() {
        return this.planService.getPlans();
    }
}
