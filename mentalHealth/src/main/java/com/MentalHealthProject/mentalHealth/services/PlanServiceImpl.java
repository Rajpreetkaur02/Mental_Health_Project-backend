package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.PlanDao;
import com.MentalHealthProject.mentalHealth.entities.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanDao planDao;

    private int week = 0;

    @Override
    public List<Plan> getPlans() {
        return planDao.findAll();
    }
    @Override
    @Scheduled(cron = "0 0 0 * * WED")
    public void incrementWeek() {
        if (week < 3) {
            week = week + 1;
        } else {
            week = 0;
        }
    }

    @Override
    public List<String> getSpecificPlan(String age) {
        List<Plan> plans = getPlans();
        for (int i = 0; i < plans.size(); i++) {
            if (plans.get(i).getAge().equals(age)) {
                List<String> plan = plans.get(i).getData().get(week);
                return plan;
            }
        }
        return null;
    }



}
