package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.TherapistDao;
import com.MentalHealthProject.mentalHealth.entities.Appointments;
import com.MentalHealthProject.mentalHealth.entities.Therapist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TherapistServiceImpl implements TherapistService {

    @Autowired
    private TherapistDao therapistDao;

    @Override
    public List<Therapist> getTherapists() {
        return this.therapistDao.findAll();
    }

    @Override
    public Therapist getSpecificTherapist(String id) {
        Optional<Therapist> therapist = therapistDao.findById(id);
        return therapist.get();
    }

    @Override
    public List<Appointments> getAppointments(String id) {
        Optional<Therapist> therapist = therapistDao.findById(id);
        return therapist.get().getAppointments();
    }

    @Override
    public Therapist updateTherapist(String therapistId, String timestamp) {
        System.out.println(timestamp);
        Optional<Therapist> therapist = therapistDao.findById(therapistId);
        Therapist specificTherapist = therapist.get();

        for (Appointments a : specificTherapist.getAppointments()) {
            System.out.println(a.getTimestamp());
            if (a.getTimestamp().trim().equals(timestamp.replace("\"", "").trim())) {
                a.setAvailability(false);
            }
            System.out.println(specificTherapist.getAppointments().get(1).getAvailability());
        }
        return this.therapistDao.save(specificTherapist);
    }
}
