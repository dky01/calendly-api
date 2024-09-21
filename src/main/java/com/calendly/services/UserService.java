package com.calendly.services;

import com.calendly.db.user.UserRepository;
import com.calendly.models.User;

import javax.inject.Inject;

public class UserService {
    private UserRepository repository;

    @Inject
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public void addUser(User user) {
        repository.addUser(user);
    }

    public User getUser(String userId) {
        return repository.getUser(userId);
    }
}
