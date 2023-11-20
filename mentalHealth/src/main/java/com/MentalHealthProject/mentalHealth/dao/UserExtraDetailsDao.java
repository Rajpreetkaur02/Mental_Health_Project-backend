package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserExtraDetailsDao extends MongoRepository<UserExtraDetails, String> {
    public UserExtraDetails findByUserId(String userId);
}
