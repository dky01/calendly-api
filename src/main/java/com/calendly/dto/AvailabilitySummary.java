package com.calendly.dto;

import com.calendly.models.Slot;

import java.util.List;

public class AvailabilitySummary {
    private String userId;
    private String date;
    private List<Slot> availableSlots;
    private List<Slot> bookedSlots;

    public AvailabilitySummary() {}

    public AvailabilitySummary(List<Slot> availableSlots, List<Slot> bookedSlots, String userId, String date) {
        this.availableSlots = availableSlots;
        this.bookedSlots = bookedSlots;
        this.userId = userId;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public List<Slot> getAvailableSlots() {
        return availableSlots;
    }

    public List<Slot> getBookedSlots() {
        return bookedSlots;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAvailableSlots(List<Slot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public void setBookedSlots(List<Slot> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }
}
