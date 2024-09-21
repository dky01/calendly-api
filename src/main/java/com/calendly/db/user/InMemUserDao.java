package com.calendly.db.user;

import com.calendly.models.User;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class InMemUserDao implements UserDao {
    private Map<String, User> users = new HashMap<>();
    @Override
    public void insert(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
