package com.calendly.db.user;

import com.calendly.models.User;

import javax.inject.Inject;

public class UserRepository {
    private UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.insert(user);
    }

    public User getUser(String userId) {
        return userDao.findById(userId);
    }

}
