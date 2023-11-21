package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserExtraDetailsDao;
import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserExtraDetailsServiceImpl implements UserExtraDetailsService {

    @Autowired
    private UserExtraDetailsDao userExtraDetailsDao;

    @Override
    public UserExtraDetails getSpecificDetail(String userId) {
        return userExtraDetailsDao.findByUserId(userId);
    }

    @Override
    public UserExtraDetails addDetails(UserExtraDetails userExtraDetails) {
        return userExtraDetailsDao.save(userExtraDetails);
    }

    @Override
    public List<Mood> getMood(String userId) {
        UserExtraDetails user = userExtraDetailsDao.findByUserId(userId);
        return user.getMood();
    }

    @Override
    public List<String> getGroupsJoined(String userId) {
        UserExtraDetails user = userExtraDetailsDao.findByUserId(userId);
        return user.getGroupsJoined();
    }

    @Override
    public void addGroups(String userId, String groupId) throws Exception {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        List<String> groups;
        if (userDetail.getGroupsJoined() != null) {
            groups = userDetail.getGroupsJoined();
            for (int i = 0; i < groups.size(); i++) {
                if (Objects.equals(groups.get(i), groupId)) {
                    throw new RuntimeException("Error in business logic");
                }
            }
        } else {
            groups = new ArrayList<>();
        }
        groups.add(groupId);
        userDetail.setGroupsJoined(groups);
        userExtraDetailsDao.save(userDetail);
    }

    @Override
    public UserExtraDetails addMood(String userId, Mood userMood) {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        List<Mood> mood;
        if(userDetail.getMood() != null) {
            mood = userDetail.getMood();
        } else {
            mood = new ArrayList<>();
        }
        mood.add(userMood);
        userDetail.setMood(mood);
        return userExtraDetailsDao.save(userDetail);
    }
}
