package com.calendly.dto;

import java.util.Set;

public class CreateEventRequest {
    private String creatorUserId;
    private String opponentUserId;
    private String date;
    private Set<Integer> slotIndices;

    public CreateEventRequest() {};

    public CreateEventRequest(String creatorUserId, String opponentUserId, String date, Set<Integer> slotIndices) {
        this.creatorUserId = creatorUserId;
        this.opponentUserId = opponentUserId;
        this.date = date;
        this.slotIndices = slotIndices;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getOpponentUserId() {
        return opponentUserId;
    }

    public void setOpponentUserId(String opponentUserId) {
        this.opponentUserId = opponentUserId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Integer> getSlotIndices() {
        return slotIndices;
    }

    public void setSlotIndices(Set<Integer> slotIndices) {
        this.slotIndices = slotIndices;
    }
}
