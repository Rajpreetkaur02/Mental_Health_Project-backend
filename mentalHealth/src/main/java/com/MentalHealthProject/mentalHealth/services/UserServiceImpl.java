package com.MentalHealthProject.mentalHealth.services;

import com.MentalHealthProject.mentalHealth.dao.UserDao;
import com.MentalHealthProject.mentalHealth.entities.EmergencyContact;
import com.MentalHealthProject.mentalHealth.entities.User;
import com.mongodb.DuplicateKeyException;
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
        try {
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            userDao.save(user);
            return user;
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("Email already exists!");
        }
    }

    @Override
    public User getSpecificUser(String email) {
        return this.userDao.findByEmail(email);
    }

    @Override
    public User updateUser(String email, User user) {
        User newUser = getSpecificUser(email);
        newUser.setAge(user.getAge());
        newUser.setGender(user.getGender());
        newUser.setIncome(user.getIncome());
        userDao.save(newUser);
        return newUser;
    }

    @Override
    public String getAge(String email) {
        User user = getSpecificUser(email);
        return user.getAge();
    }
}
