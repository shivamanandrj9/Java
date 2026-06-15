package booking.managers.impl;

public class LocalBookingManager implements BookingManager {
    
    ConcurrentHashMap<String, ReentrantLock> lockStatus;
    
    public LocalBookingManager(ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, ReentrantLock>> lockStatus){
        this.lockStatus=lockStatus;
    }
    
    boolean acquireLock(LocalDate date, Integer roomId, Integer startSlot, Integer endSlot){
        
        for(int i=startSlot; i<=endSlot; i++){
            String key=generateKey(roomId, date, i);
            ReentrantLock slotLock=this.lockStatus.computeIfAbsent(key, key->{
                return new ReentrantLock();
            });
            if(slotLock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println("Lock acquired for "+ key);
            } else {
                return false;
            }
        }
        return true;
    }
    
    boolean relaseLock(LocalDate date, Integer roomId, Integer startSlot, Integer endSlot){
        for(int i=startSlot, i<=endSlot; i++){
            String key=generateKey(roomId, date, i);
            ReentrantLock slotLock=this.lockStatus.computeIfAbsent(key, key->{
                return new ReentrantLock();
            });
            slotLock.unlock();
        }
    }
    
    private String generateKey(Integer roomId, Integer date, Integer slot){
        return (roomId.toString()+" "+date.toString()+" "+slot.toString());
    }
}