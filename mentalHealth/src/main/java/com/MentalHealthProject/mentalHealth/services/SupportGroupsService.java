package com.MentalHealthProject.mentalHealth.services;


import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SupportGroupsService {
    public List<SupportGroups> getSupportGroups();

    public SupportGroups addSupportGroups(SupportGroups supportGroups);

    public SupportGroups getSpecificGroup(String id);

    public SupportGroups updateGroup(String id);
}
