package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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

    private List<CommunityPosts> CommunityPosts;

    private List<Review> Reviews;

    public List<Event> Events;

    public SupportGroups() {

    }

    public SupportGroups(String _id, String title, Long members, String organizer, String type, String about, String location, String topics, List<CommunityPosts> CommunityPosts, List<Review> Reviews, List<Event> Events) {
        this._id = _id;
        this.title = title;
        this.members = members;
        this.organizer = organizer;
        this.type = type;
        this.about = about;
        this.location = location;
        this.topics = topics;
        this.CommunityPosts = CommunityPosts;
        this.Reviews = Reviews;
        this.Events = Events;
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

    public List<CommunityPosts> getCommunityPosts() {
        return CommunityPosts;
    }

    public void setCommunityPosts(List<CommunityPosts> communityPosts) {
        CommunityPosts = communityPosts;
    }

    public List<Review> getReviews() { return Reviews; }

    public void setReviews(List<Review> reviews) { Reviews = reviews; }

    public List<Event> getEvents() { return Events; }

    public void setEvents(List<Event> events) { Events = events; }

}
