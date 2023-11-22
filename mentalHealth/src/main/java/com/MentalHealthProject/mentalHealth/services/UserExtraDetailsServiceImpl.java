package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserExtraDetailsDao;
import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserExtraDetailsServiceImpl implements UserExtraDetailsService {

    private final MongoTemplate mongoTemplate;

    public UserExtraDetailsServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

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
    public List<Mood> getMood(String userId, String date) {
        System.out.println(date);
        UserExtraDetails user = userExtraDetailsDao.findByUserId(userId);
        List<Mood> moods = new ArrayList<>();
        for (int i = 0; i < user.getMood().size(); i++) {
            if (Objects.equals(user.getMood().get(i).getOnlyDate(), date)) {
                moods.add(user.getMood().get(i));
            }
        }
        System.out.println(moods);
        return moods;
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

    @Override
    public List<Mood> getAllMoods(String userId) {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        return userDetail.getMood();
    }

    @Override
    public int moodAvg(List<Mood> moods) {
        int value = 0, avg = 0;
        for (int i = 0; i < moods.size(); i++) {
            System.out.println(moods.get(i).getMood().substring(2));
            if (moods.get(i).getMood().substring(3).equals("Neutral")) {
                value += 2;
            } else if (moods.get(i).getMood().substring(3).equals("Happy")) {
                value += 3;
            } else if (moods.get(i).getMood().substring(3).equals("Sad")) {
                value += 1;
            }
        }
        System.out.println(value);
        avg = value / moods.size();
        System.out.println(avg);
        return avg;
    }

    @Override
    public Map<String, List<Mood>> sortedMoods(List<Mood> moods) {
        List<Mood> sameMoods = new ArrayList<>();
        Map<String, List<Mood>> groupedMap = moods.stream()
                .collect(Collectors.groupingBy(Mood::getOnlyDate));
        return groupedMap;
    }

    @Override
    public Map<String, Integer> returnAvg(String userId) {
        List<Mood> moods = getAllMoods(userId);
        Map<String, List<Mood>> ans = sortedMoods(moods);
        Map<String, Integer> avgOfMoods = new HashMap<>();

        ans.forEach((key, value) -> {
            int avg = moodAvg(value);
            avgOfMoods.put(key, avg);
        });
        System.out.println(avgOfMoods);
        return avgOfMoods;
    }



}
