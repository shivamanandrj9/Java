package services;

import java.util.*;
import java.lang.*;

public class BookingService {
    
    BookingManager bookingManager;
    RoomReservationDao roomReservationDao;
    
    public BookingService(BookingManager bookingManager, RoomReservationDao roomReservationDao){
        this.bookingManager=bookingManager;
        this.roomReservationDao=roomReservationDao;
    }
    
    public Integer bookRoom(Integer roomId, Integer userId, LocalTime startTime, LocalTime endTime, LocalDate date){
        List<Integer> slots=getSlots(startTime, endTime);
        bookingManager.acquireLock(date, roomId, slots.get(0), slots.get(1));
        RoomReservation roomReservation=RoomReservation.builder().userId(userId).roomId(roomId).date(date).startTime(startTime).endTime(endTime).isActive(Boolean.TRUE).build();
        bookingManager.releaseLock(date, roomId, slots.get(0), slots.get(1));
        return roomReservation.getId();
    }
    
    private List<Integer> getSlots(LocalTime startTime, LocalTime endTime){
        int startMinutes=startTime.getHour()*60+startTime.getMinute();
        int endMinutes=endTime.getHour()*60+endTime.getMinute();
        
        int startSlot=startMinutes/30;
        int endSlot=endMinutes/30;
        
        List<Integer> slots=new ArrayList<>();
        slots.add(startSlot);
        slots.add(endSlot);
        

        return slots;
        
    }
}