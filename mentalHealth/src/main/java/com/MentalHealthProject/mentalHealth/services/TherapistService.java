package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.entities.Appointments;
import com.MentalHealthProject.mentalHealth.entities.Therapist;

import java.util.List;

public interface TherapistService {
    public List<Therapist> getTherapists();

    public Therapist updateTherapist(String therapistId, String timestamp);
}
