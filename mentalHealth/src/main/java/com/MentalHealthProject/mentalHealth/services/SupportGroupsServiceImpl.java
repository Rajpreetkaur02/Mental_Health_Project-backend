package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.SupportGroupsDao;
import com.MentalHealthProject.mentalHealth.entities.SupportGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportGroupsServiceImpl implements SupportGroupsService {

    @Autowired
    private SupportGroupsDao supportGroupsDao;

    @Override
    public List<SupportGroups> getSupportGroups() {
        return supportGroupsDao.findAll();
    }

    @Override
    public SupportGroups addSupportGroups(SupportGroups supportGroups) {
        supportGroupsDao.save(supportGroups);
        return supportGroups;
    }

    @Override
    public Optional<SupportGroups> getSpecificGroup(String id) {
        Optional<SupportGroups> supportGroup = supportGroupsDao.findById(id);
        return supportGroup;
    }

    @Override
    public SupportGroups updateGroup(String id) {
        Optional<SupportGroups> specificGroup = supportGroupsDao.findById(id);
        Long noOfMembers = specificGroup.get().getMembers();
        specificGroup.get().setMembers(noOfMembers + 1);
        return supportGroupsDao.save(specificGroup.get());
    }


}
