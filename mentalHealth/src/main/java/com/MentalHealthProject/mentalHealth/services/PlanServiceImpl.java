package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.PlanDao;
import com.MentalHealthProject.mentalHealth.entities.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;


@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanDao planDao;

    private int week;

    @Override
    public List<Plan> getPlans() {
        return planDao.findAll();
    }

    @Override
    public int getWeekFromDate(LocalDate date) {
        return date.get(WeekFields.ISO.weekOfYear());
    }

    @Override
    @Scheduled(cron = "0 0 0 * * MON")
    public void incrementWeek() {
        LocalDate date = LocalDate.now();
        int weekNumber = getWeekFromDate(date);
        week = weekNumber % 4;
        System.out.println("This week is " + week);
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
