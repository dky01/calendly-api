package com.calendly.db.user;

import com.calendly.models.User;

public interface UserDao {
    void insert(User user);
    User findById(String id);
}
