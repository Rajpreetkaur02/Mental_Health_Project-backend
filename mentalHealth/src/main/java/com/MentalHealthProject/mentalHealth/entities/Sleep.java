package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sleep {
    private Integer hours;
    private String dateTime;

    public Sleep() {
    }

    public Sleep(Integer hours, String dateTime) {
        this.hours = hours;
        this.dateTime = dateTime;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
