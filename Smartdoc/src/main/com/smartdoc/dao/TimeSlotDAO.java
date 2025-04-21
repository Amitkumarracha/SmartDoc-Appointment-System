package main.com.smartdoc.dao;


import main.com.smartdoc.model.TimeSlot;
import java.util.List;

public interface TimeSlotDAO extends DAO<TimeSlot> {
    List<TimeSlot> getAvailableSlotsForDoctor(int doctorId);
    void markSlotAsBooked(int slotId);
}