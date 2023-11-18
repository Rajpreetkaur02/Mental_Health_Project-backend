package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserExtraDetailsDao;
import com.MentalHealthProject.mentalHealth.entities.UserExtraDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExtraDetailsServiceImpl implements UserExtraDetailsService {

    @Autowired
    private UserExtraDetailsDao userExtraDetailsDao;

    @Override
    public UserExtraDetails addDetails(UserExtraDetails userExtraDetails) {
        return userExtraDetailsDao.save(userExtraDetails);
    }
}
