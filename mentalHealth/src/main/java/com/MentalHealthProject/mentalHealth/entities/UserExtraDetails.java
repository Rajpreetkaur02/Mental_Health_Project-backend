package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("extraDetails")
public class UserExtraDetails {
    private String _id;
    private String userId;
    private String result;
    private List<Mood> mood;
    private Integer sleep;
    private String type;
    private List<Boolean> tasksCompleted;
    private List<String> groupsJoined;

    public UserExtraDetails() {
    }

    public UserExtraDetails(String _id, String userId, String result, List<Mood> mood, Integer sleep, String type, List<Boolean> tasksCompleted, List<String> groupsJoined) {
        this._id = _id;
        this.userId = userId;
        this.result = result;
        this.mood = mood;
        this.sleep = sleep;
        this.type = type;
        this.tasksCompleted = tasksCompleted;
        this.groupsJoined = groupsJoined;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Mood> getMood() {
        return mood;
    }

    public void setMood(List<Mood> mood) {
        this.mood = mood;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getGroupsJoined() {
        return groupsJoined;
    }

    public void setGroupsJoined(List<String> groupsJoined) {
        this.groupsJoined = groupsJoined;
    }

    public List<Boolean> getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(List<Boolean> tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }
}
