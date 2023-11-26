package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.Plan;

import java.time.LocalDate;
import java.util.List;

public interface PlanService {
    public List<Plan> getPlans();

    public int getWeekFromDate(LocalDate date);

    public List<String> getSpecificPlan(String age);

    public void incrementWeek();
}
