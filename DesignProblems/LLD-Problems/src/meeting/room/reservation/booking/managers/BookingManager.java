package booking.managers;


public interface BookingManager {
    boolean acquireLock(LocalDate date, Integer roomId, Integer startSlot, Integer endSlot);
    void releaseLock(LocalDate date, Integer roomId, Integer startSlot, Integer endSlot);
}