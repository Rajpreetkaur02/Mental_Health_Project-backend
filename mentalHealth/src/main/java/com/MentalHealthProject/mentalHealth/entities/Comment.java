package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
    private String username;
    private String content;
    private String timestamp;

    public Comment(){
    }

    public Comment(String commentID, String username, String content, String timestamp){
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
