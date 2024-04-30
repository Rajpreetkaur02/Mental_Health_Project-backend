package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.SupportGroupsDao;
import com.MentalHealthProject.mentalHealth.entities.Comment;
import com.MentalHealthProject.mentalHealth.entities.CommunityPosts;
import com.MentalHealthProject.mentalHealth.entities.Review;
import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupportGroupsServiceImpl implements SupportGroupsService {

    @Autowired
    private SupportGroupsDao supportGroupsDao;

    @Override
    public List<SupportGroups> getSupportGroups() {
        return supportGroupsDao.findAll();
    }

    @Override
    public SupportGroups addSupportGroups(SupportGroups supportGroups) {
        supportGroupsDao.save(supportGroups);
        return supportGroups;
    }

    @Override
    public SupportGroups getSpecificGroup(String id) {
        Optional<SupportGroups> supportGroup = supportGroupsDao.findById(id);
        return supportGroup.get();
    }

    @Override
    public SupportGroups updateGroup(String id) {
        Optional<SupportGroups> specificGroup = supportGroupsDao.findById(id);
        Long noOfMembers = specificGroup.get().getMembers();

        specificGroup.get().setMembers(noOfMembers + 1);

//        if (type.equals("add")) specificGroup.get().setMembers(noOfMembers + 1);
//        else if (type.equals("leave")) specificGroup.get().setMembers(noOfMembers - 1);

        return supportGroupsDao.save(specificGroup.get());
    }

    @Override
    public SupportGroups addPosts(String id, CommunityPosts communitypost) {
        Optional<SupportGroups> group;
        group = supportGroupsDao.findById(id);
        List<CommunityPosts> post;
        if (group.get().getCommunityPosts() == null) {
            post = new ArrayList<>();
        } else {
            post = group.get().getCommunityPosts();
        }
        post.add(communitypost);
        group.get().setCommunityPosts(post);
        return supportGroupsDao.save(group.get());
    }

    @Override
    public List<CommunityPosts> getPosts(String id, String date) {
        Optional<SupportGroups> group;
        group = supportGroupsDao.findById(id);
        return group.get().getCommunityPosts();
    }

    @Override
    public SupportGroups updatePostLikes(String id, String postID, Boolean liked) {
        System.out.println("liked: " + liked);

        Optional<SupportGroups> group = supportGroupsDao.findById(id);
        if (group.isPresent()) {
            List<CommunityPosts> posts = group.get().getCommunityPosts();

            for (CommunityPosts post : posts) {
                System.out.println("Checking post ID: " + post.getPostID());
                System.out.println("equals: " + postID);
                if (postID.equals("\"" + post.getPostID() + "\"")) {
                    System.out.println("Found matching post ID, updating likes");
                    Long noOfLikes = post.getLikes();
                    System.out.println(noOfLikes);
                    if(liked){
                        post.setLikes(noOfLikes + 1);
                    }else {
                        post.setLikes(noOfLikes - 1);
                    }
                    break;
                }else{
                    System.out.println("not Found");
                }
            }
            group.get().setCommunityPosts(posts);
            return supportGroupsDao.save(group.get());
        } else {
            return null;
        }
    }

    @Override
    public SupportGroups addComment(String id, Comment comment, String postID) {
        Optional<SupportGroups> group = supportGroupsDao.findById(id);
        if (group.isPresent()) {
            List<CommunityPosts> posts = group.get().getCommunityPosts();

            for (CommunityPosts post : posts) {
                System.out.println("Checking post ID: " + post.getPostID());
                System.out.println("equals: " + postID);

                if (postID.equals(post.getPostID())) {
                    List<Comment> comments;
                    if(post.getComments() == null){
                        comments = new ArrayList<>();
                    }else{
                        comments = post.getComments();
                    }
                    comments.add(comment);
                    post.setComments(comments);
                    break;
                }else{
                    System.out.println("not Found");
                }
            }
            group.get().setCommunityPosts(posts);
            return supportGroupsDao.save(group.get());
        } else {
            return null;
        }
    }

    @Override
    public SupportGroups addReview(String id, Review review) {
        Optional<SupportGroups> group;
        group = supportGroupsDao.findById(id);
        List<Review> reviews;
        if (group.get().getReviews() == null) {
            reviews = new ArrayList<>();
        } else {
            reviews = group.get().getReviews();
        }
        reviews.add(review);
        group.get().setReviews(reviews);
        return supportGroupsDao.save(group.get());
    }

    @Override
    public List<Review> getReviewsList(String id, String date) {
        Optional<SupportGroups> group;
        group = supportGroupsDao.findById(id);
        return group.get().getReviews();
    }
}
