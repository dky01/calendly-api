package com.calendly.models;

import com.calendly.exception.InvalidTimeSlotException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Slot {
    private int index;
    private Slot(int index) {
        this.index = index;
    };

    public static Slot ofIndex(int index) {
        if (index < 0 || index > 96) {
            throw new InvalidTimeSlotException("invalid index: " + index + " valid range is [1-96] ");
        }
        return new Slot(index);
    }

    public int getIndex() {
        return index;
    }

    public Pair<String> getTimeStamps() {
        int totalMins = (index - 1) * 15;
        LocalTime startTime = LocalTime.of(0, 0).plusMinutes(totalMins);
        LocalTime endTime = startTime.plusMinutes(15);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String start = startTime.format(formatter);
        String end = endTime.format(formatter);
        return new Pair<>(start, end);
    }
}
