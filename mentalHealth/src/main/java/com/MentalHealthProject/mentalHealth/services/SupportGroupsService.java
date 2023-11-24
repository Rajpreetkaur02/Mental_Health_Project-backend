package com.MentalHealthProject.mentalHealth.services;


import com.MentalHealthProject.mentalHealth.entities.Comment;
import com.MentalHealthProject.mentalHealth.entities.CommunityPosts;
import com.MentalHealthProject.mentalHealth.entities.SupportGroups;

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


}
