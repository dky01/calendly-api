package com.calendly.dto;

import java.util.Set;

public class AddAvailabilityRequest {
    private String userId;
    private String date;
    private Set<Integer> slots;
    public AddAvailabilityRequest() {}

    public AddAvailabilityRequest(String userId, String date, Set<Integer> slots) {
        this.userId = userId;
        this.date = date;
        this.slots = slots;
    }
    public String getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public Set<Integer> getSlots() {
        return slots;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSlots(Set<Integer> slots) {
        this.slots = slots;
    }

}
