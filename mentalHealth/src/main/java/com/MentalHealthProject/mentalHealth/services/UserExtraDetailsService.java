package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.Sleep;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;

import java.util.List;
import java.util.Map;

public interface UserExtraDetailsService {
    public UserExtraDetails getSpecificDetail(String userId);

    public UserExtraDetails addDetails(UserExtraDetails userExtraDetails);

    public UserExtraDetails addMood(String userId, Mood mood);

    public List<Mood> getAllMoods(String userId);

    public List<Mood> getMood(String userId, String date);

    public void addGroups(String userId, String groupId) throws Exception;

    public List<String> getGroupsJoined(String userId);

    public int moodAvg(List<Mood> moods);

    public Map<String, Integer> returnAvg(String userId);

    public Map<String, List<Mood>> sortedMoods(List<Mood> moods);

    public void addTasks(String userId, List<Boolean> completed);

    public List<Boolean> tasksCompleted(String userId) throws Exception;

    public UserExtraDetails addSleep(String userId, Sleep sleep);

    public Map<String, Integer> getSleep(String userId);
}
