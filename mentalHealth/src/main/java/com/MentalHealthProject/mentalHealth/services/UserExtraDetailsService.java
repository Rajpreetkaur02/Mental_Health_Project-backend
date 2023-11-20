package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;

import java.util.List;

public interface UserExtraDetailsService {
    public UserExtraDetails addDetails(UserExtraDetails userExtraDetails);

    public UserExtraDetails addMood(String userId, Mood mood);

    public List<Mood> getMood(String userId);
}
