package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupportGroupsDao extends MongoRepository<SupportGroups, String> {
}
