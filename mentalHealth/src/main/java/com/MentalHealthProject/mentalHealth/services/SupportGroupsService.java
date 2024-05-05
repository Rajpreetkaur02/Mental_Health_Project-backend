package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.*;

import java.util.List;

public interface SupportGroupsService {
    public List<SupportGroups> getSupportGroups();

    public SupportGroups addSupportGroups(SupportGroups supportGroups);

    public SupportGroups getSpecificGroup(String id);

    public SupportGroups updateGroup(String id);

    public SupportGroups addPosts(String id, CommunityPosts communitypost);

    public List<CommunityPosts> getPosts(String id, String date);

    public SupportGroups updatePostLikes(String id, String postID, Boolean liked);

    public SupportGroups addComment(String id, Comment comment, String postID);

    public SupportGroups addReview(String id, Review review);

    public List<Review> getReviewsList(String id, String date);

    public SupportGroups addEvent(String id, Event event);
    public List<Event> getEventsList(String id, String date);
}
