package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.Therapist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TherapistDao extends MongoRepository<Therapist, String> {
}
