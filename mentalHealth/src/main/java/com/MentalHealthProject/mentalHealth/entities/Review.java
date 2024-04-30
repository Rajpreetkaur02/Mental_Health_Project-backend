package com.MentalHealthProject.mentalHealth.entities;

public class Review {
    private String reviewID;
    private String username;
    private String review;
    private int rating;
    private String timestamp;

    public Review(){

    }

    public Review(String reviewID, String username, String review, int rating, String timestamp){
        this.reviewID = reviewID;
        this.username = username;
        this.rating = rating;
        this.review = review;
        this.timestamp = timestamp;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
