package com.MentalHealthProject.mentalHealth.entities;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("blogposts")
public class BlogPost {
    private String _id;
    private String title;
    private Binary img;
    private String category;
    private String content;
    private String author;
    @CreatedDate
    private String timestamp;
    public BlogPost() {
    }

    public BlogPost(String _id, String title, Binary img, String category, String content, String author, String timestamp) {
        this._id = _id;
        this.title = title;
        this.img = img;
        this.category = category;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
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

    public Binary getImg() {
        return img;
    }

    public void setImg(Binary img) {
        this.img = img;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
