package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserDao;
import com.MentalHealthProject.mentalHealth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User addUser(User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;
    }

    @Override
    public User getSpecificUser(String email) {
        return this.userDao.findByEmail(email);
    }
}
