package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("plan")
public class Plan {
    private String id;
    private String age;
    private List<List<String>> data;

    public Plan() {
    }

    public Plan(String id, String age, List<List<String>> data) {
        this.id = id;
        this.age = age;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
