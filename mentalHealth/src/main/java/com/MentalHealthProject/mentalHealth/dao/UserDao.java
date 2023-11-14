package com.MentalHealthProject.mentalHealth.dao;

import com.MentalHealthProject.mentalHealth.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {
    public User findByEmail(String email);
}
