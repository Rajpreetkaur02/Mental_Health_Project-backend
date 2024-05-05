package com.MentalHealthProject.mentalHealth.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Event {
    private String EventID;
    private String EventTitle;
    private String description;
    private String hostedby;
    private String location;
    private String paidorfree;
    private String mode;
    private int charges;
    private String link;
    private LocalDate date;
    private String time;

    public Event(String EventID, String EventTitle, String description, String hostedby, String location, String paidorfree, String mode, int charges, String link, LocalDate date, String time){
        this.EventID = EventID;
        this.EventTitle = EventTitle;
        this.description = description;
        this.hostedby = hostedby;
        this.location = location;
        this.paidorfree = paidorfree;
        this.mode = mode;
        this.charges = charges;
        this.link = link;
        this.date = date;
        this.time = time;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public void setEventTitle(String eventTitle) {
        EventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHostedby() {
        return hostedby;
    }

    public void setHostedby(String hostedby) {
        this.hostedby = hostedby;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPaidorfree() {
        return paidorfree;
    }

    public void setPaidorfree(String paidorfree) {
        this.paidorfree = paidorfree;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
