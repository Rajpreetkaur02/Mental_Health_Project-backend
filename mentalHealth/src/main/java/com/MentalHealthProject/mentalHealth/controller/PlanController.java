package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.Plan;
import com.MentalHealthProject.mentalHealth.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/plan/{age}")
    public List<String> getSpecificPlan(@PathVariable String age) {
        return this.planService.getSpecificPlan(age);
    }
}
