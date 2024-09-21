package com.calendly.db.availability;

import com.calendly.dto.AvailabilitySummary;
import com.calendly.models.Slot;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class AvailabilityRepository {
    private AvailabilityDao availabilityDao;

    @Inject
    public AvailabilityRepository(AvailabilityDao availabilityDao) {
        this.availabilityDao = availabilityDao;
    }

    public void insertSlot(String userId, String date, int availabilitySlotIndex) {
        availabilityDao.insert(userId, date, availabilitySlotIndex);
    }

    public void insertSlots(String userId, String date, Set<Integer> availabilityIndices) {
        for (Integer availabilityIndex : availabilityIndices) {
            insertSlot(userId, date, availabilityIndex);
        }
    }

    public void bookSlot(String date, int availabilitySlotIndex, String userId) {
        availabilityDao.bookSlot(date, availabilitySlotIndex, userId);
    }

    public List<Slot> getCommonAvailableSlots(String userId1, String userId2, String date) {
        return availabilityDao.getCommonAvailableSlots(userId1, userId2, date);
    }

    public AvailabilitySummary getAvailabilitySummary(String userId, String date) {
        return availabilityDao.getSummary(userId, date);
    }

}
