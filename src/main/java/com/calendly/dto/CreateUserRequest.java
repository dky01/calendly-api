package com.calendly.dto;

import com.calendly.models.User;

public class CreateUserRequest {
    private String id;
    private String name;
    private String email;

    public CreateUserRequest() {};

    public CreateUserRequest(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User toNewUser() {
        return new User(id, name, email);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
