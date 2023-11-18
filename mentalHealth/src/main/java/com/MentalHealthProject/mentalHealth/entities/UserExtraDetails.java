package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("extraDetails")
public class UserExtraDetails {
    private String _id;
    @Indexed(unique = true)
    private String userId;
    private Object mood;
    private Integer sleep;
    private String type;
    private String groupId;

    public UserExtraDetails() {
    }

    public UserExtraDetails(String _id, String userId, Object mood, Integer sleep, String type, String groupId) {
        this._id = _id;
        this.userId = userId;
        this.mood = mood;
        this.sleep = sleep;
        this.type = type;
        this.groupId = groupId;
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

    public Object getMood() {
        return mood;
    }

    public void setMood(Object mood) {
        this.mood = mood;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
