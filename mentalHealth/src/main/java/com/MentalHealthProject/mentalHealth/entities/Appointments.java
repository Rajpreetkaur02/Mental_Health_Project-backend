package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Appointments {
    private String timestamp;
    private Boolean availability;

    public Appointments() {
    }

    public Appointments(String timestamp, Boolean availability) {
        this.timestamp = timestamp;
        this.availability = availability;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
