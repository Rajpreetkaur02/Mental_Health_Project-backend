package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserExtraDetailsDao;
import com.MentalHealthProject.mentalHealth.entities.Mood;
import com.MentalHealthProject.mentalHealth.entities.Sleep;
import com.MentalHealthProject.mentalHealth.entities.User;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<Mood> getMood(String userId, String date) {
        System.out.println(date);
        UserExtraDetails user = userExtraDetailsDao.findByUserId(userId);
        List<Mood> moods = new ArrayList<>();
        if (user.getMood() != null) {
            for (int i = 0; i < user.getMood().size(); i++) {
                if (Objects.equals(user.getMood().get(i).getOnlyDate(), date)) {
                    moods.add(user.getMood().get(i));
                }
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
    public void manageGroups(String userId, String groupId) throws Exception {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        List<String> groups;
        if (userDetail.getGroupsJoined() != null) {
            groups = userDetail.getGroupsJoined();
//            if (type.equals("leave")) groups.remove(groupId);
//            for (String group : groups) {
//                if (Objects.equals(group, groupId)) {
//                    throw new RuntimeException("Error in business logic");
//                }
//            }
        } else {
            groups = new ArrayList<>();
        }
//        if (type.equals("join")) groups.add(groupId);
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
    public UserExtraDetails addResult(String userId, String result) {
        UserExtraDetails userDetails = userExtraDetailsDao.findByUserId(userId);
        userDetails.setResult(result);
        return userExtraDetailsDao.save(userDetails);
    }

    @Override
    public UserExtraDetails addReports(String userId, MultipartFile file) throws IOException {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        List<Binary> reports;
        if (userDetail.getReports() != null) {
            reports = userDetail.getReports();
        } else {
            reports = new ArrayList<>();
        }
        reports.add(new Binary(file.getBytes()));
        userDetail.setReports(reports);
        return userExtraDetailsDao.save(userDetail);
    }

    @Override
    public List<Binary> getUserReport(String userId) {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        return userDetail.getReports();
    }

    @Override
    public int getTotalReports(String userId) {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        List<Binary> reports = userDetail.getReports();
        return reports == null ? 0 : reports.size();
    }

    @Override
    public List<Mood> getAllMoods(String userId) {
        UserExtraDetails userDetail = userExtraDetailsDao.findByUserId(userId);
        return userDetail.getMood();
    }

    @Override
    public int moodAvg(List<Mood> moods) {
        int value = 0, avg = 0;
        for (Mood mood : moods) {
            System.out.println(mood.getMood().substring(2));
            switch (mood.getMood().substring(3)) {
                case "Neutral" -> value += 2;
                case "Happy" -> value += 3;
                case "Sad" -> value += 1;
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
        Map<String, List<Mood>> groupedMap = new HashMap<>();
        if (moods.size() != 0) {
            groupedMap = moods.stream()
                    .collect(Collectors.groupingBy(Mood::getOnlyDate));
        }
        return groupedMap;
    }

    @Override
    public void addTasks(String userId, List<Boolean> completed) {
        UserExtraDetails user = getSpecificDetail(userId);
        user.setTasksCompleted(completed);
        userExtraDetailsDao.save(user);
    }

    @Override
    public List<Boolean> tasksCompleted(String userId) throws Exception {
        UserExtraDetails user = getSpecificDetail((userId));
        if (user.getTasksCompleted().isEmpty()) {
            throw new RuntimeException("No tasks found");
        }
        return user.getTasksCompleted();
    }

    @Override
    public UserExtraDetails addSleep(String userId, Sleep sleep) {
        UserExtraDetails user = getSpecificDetail(userId);
        List<Sleep> sleepDetail;
        if (user.getSleep() != null) {
            sleepDetail = user.getSleep();
        } else {
            sleepDetail = new ArrayList<>();
        }
        sleepDetail.add(sleep);
        user.setSleep(sleepDetail);
        return userExtraDetailsDao.save(user);
    }

    @Override
    public Map<String, Integer> getSleep(String userId) {
        UserExtraDetails user = getSpecificDetail(userId);
        List<Sleep> sleepList = user.getSleep();
        Map<String, Integer> sleepMap = new TreeMap<>(Comparator.naturalOrder());
        if (user.getSleep() != null) {
            sleepMap = sleepList.stream()
                    .collect(Collectors.toMap(Sleep::getDateTime, Sleep::getHours));
        }
        return sleepMap;
    }

    @Override
    public Map<String, Integer> returnAvg(String userId) {
        Map<String, Integer> avgOfMoods = new TreeMap<>(Comparator.naturalOrder());
        if (getAllMoods(userId) != null) {
            List<Mood> moods = getAllMoods(userId);
            Map<String, List<Mood>> ans = sortedMoods(moods);

            ans.forEach((key, value) -> {
                int avg = moodAvg(value);
                avgOfMoods.put(key, avg);
            });
            System.out.println(avgOfMoods);
        }
        return avgOfMoods;
    }
}
