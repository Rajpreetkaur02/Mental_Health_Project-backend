package com.MentalHealthProject.mentalHealth.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("therapists")
public class Therapist {
    private String _id;
    private String name;
    private String designation;
    private String details;
    private List<Appointments> appointments;

    public Therapist() {
    }

    public Therapist(String _id, String name, String designation, String details, List<Appointments> appointments) {
        this._id = _id;
        this.name = name;
        this.designation = designation;
        this.details = details;
        this.appointments = appointments;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}
