package com.MentalHealthProject.mentalHealth.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("supportGroups")
public class SupportGroups {
    private String _id;
    private String title;
    private Long members;
    private String organizer;
    private String type;
    private String about;
    private String location;
    private String topics;

    public SupportGroups() {

    }

    public SupportGroups(String _id, String title, Long members, String organizer, String type, String about, String location, String topics) {
        this._id = _id;
        this.title = title;
        this.members = members;
        this.organizer = organizer;
        this.type = type;
        this.about = about;
        this.location = location;
        this.topics = topics;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMembers() {
        return members;
    }

    public void setMembers(Long members) {
        this.members = members;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
