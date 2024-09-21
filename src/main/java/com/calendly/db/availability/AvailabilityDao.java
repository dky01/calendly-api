package com.calendly.db.availability;

import com.calendly.dto.AvailabilitySummary;
import com.calendly.models.Slot;

import java.util.List;
import java.util.Set;

public interface AvailabilityDao {
    void insert(String userId, String date, int availabilitySlotIndex);
    List<Slot> getCommonAvailableSlots(String userId1, String userId2, String date);
//    List<Slot> getAvailableSlotsForUser(String date, String userId);
    void bookSlot(String date, int availabilitySlotIndex, String userId);
    AvailabilitySummary getSummary(String userId, String date);
}
