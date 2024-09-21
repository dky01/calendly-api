package com.calendly.db.availability;

import com.calendly.dto.AvailabilitySummary;
import com.calendly.models.Slot;
import com.google.inject.Singleton;

import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class InMemAvailabilityDao implements AvailabilityDao {
    private Map<String, Map<String, Set<Integer>>> userIdToAvailableSlots = new HashMap<>();
    private Map<String, Map<String, Set<Integer>>> userIdToBookedSlots = new HashMap<>();

    @Override
    public void insert(String userId, String date, int availabilitySlotIndex) {
        Map<String, Set<Integer>> userAvailability = userIdToAvailableSlots.computeIfAbsent(userId, k -> new HashMap<>());
        userAvailability.computeIfAbsent(date, k -> new HashSet<>()).add(availabilitySlotIndex);
    }

    @Override
    public List<Slot> getCommonAvailableSlots(String userId1, String userId2, String date) {
        Set<Integer> user1Availability = getAvailableSlotsForUser(date, userId1);
        Set<Integer> user2Availability = getAvailableSlotsForUser(date, userId2);
        user1Availability.retainAll(user2Availability);
        return getSlotList(user1Availability);
    }

    @Override
    public void bookSlot(String date, int availabilitySlotIndex, String userId) {
        Map<String, Set<Integer>> userBookings = userIdToBookedSlots.computeIfAbsent(userId, k -> new HashMap<>());
        userBookings.computeIfAbsent(date, k -> new HashSet<>()).add(availabilitySlotIndex);
    }

    @Override
    public AvailabilitySummary getSummary(String userId, String date) {
        Set<Integer> availableSlots = userIdToAvailableSlots.getOrDefault(userId, Collections.emptyMap()).get(date);
        if (availableSlots == null) {
            return new AvailabilitySummary(Collections.emptyList(), Collections.emptyList(), userId, date);
        }
        Set<Integer> bookedSlots = userIdToBookedSlots.getOrDefault(userId, Collections.emptyMap()).get(date);
        if (bookedSlots == null) {
            bookedSlots = Collections.emptySet();
        }

        return new AvailabilitySummary(getSlotList(availableSlots), getSlotList(bookedSlots), userId, date);
    }

    private Set<Integer> getAvailableSlotsForUser(String date, String userId) {
        Map<String, Set<Integer>> userAvailability = userIdToAvailableSlots.get(userId);
        if (userAvailability == null || !userAvailability.containsKey(date)) {
            return Collections.emptySet();
        }

        Set<Integer> userAvailabilityOnDate = new HashSet<>(userAvailability.get(date));

        Map<String, Set<Integer>> userBookings = userIdToBookedSlots.get(userId);
        if (userBookings != null) {
            Set<Integer> userBookingsOnDate = userBookings.get(date);
            if (userBookingsOnDate != null) {
                userAvailabilityOnDate.removeAll(userBookingsOnDate);
            }
        }

        return userAvailabilityOnDate;
    }

    private List<Slot> getSlotList(Set<Integer> slotIndices) {
        return slotIndices.stream()
               .map(Slot::ofIndex)
               .collect(Collectors.toList());
    }
}
