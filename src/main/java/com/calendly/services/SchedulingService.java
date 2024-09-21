package com.calendly.services;

import com.calendly.db.availability.AvailabilityRepository;
import com.calendly.dto.AddAvailabilityRequest;
import com.calendly.dto.AvailabilitySummary;
import com.calendly.dto.CreateEventRequest;
import com.calendly.exception.UserNotFoundException;
import com.calendly.models.Slot;
import com.google.inject.Inject;

import java.util.List;

public class SchedulingService {
    private AvailabilityRepository repository;
    private UserService userService;

    @Inject
    public SchedulingService(AvailabilityRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void addAvailabilitySlots(AddAvailabilityRequest req) {
        if (userService.getUser(req.getUserId()) == null) {
            throw new UserNotFoundException(req.getUserId());
        }
        repository.insertSlots(req.getUserId(), req.getDate(), req.getSlots());
    }

    public void createEvent(CreateEventRequest request) {
        request.getSlotIndices().forEach(slotIndex -> {
            repository.bookSlot(request.getDate(), slotIndex, request.getCreatorUserId());
            repository.bookSlot(request.getDate(), slotIndex, request.getOpponentUserId());
        });
    }

    public List<Slot> getCommonAvailableSlots(String userId1, String userId2, String date) {
        return repository.getCommonAvailableSlots(userId1, userId2, date);
    }

    public AvailabilitySummary getAvailabilitySummary(String userId, String date) {
        return repository.getAvailabilitySummary(userId, date);
    }
}
