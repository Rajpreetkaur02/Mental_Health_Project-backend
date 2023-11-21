package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanDao extends MongoRepository<Plan, String> {
}
