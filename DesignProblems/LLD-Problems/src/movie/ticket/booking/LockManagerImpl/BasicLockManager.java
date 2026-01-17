package movie.ticket.booking.LockManagerImpl;

import movie.ticket.booking.Entities.*;
import movie.ticket.booking.Interfaces.ILockManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

public class BasicLockManager implements ILockManager {

    ConcurrentHashMap<Show, ConcurrentHashMap<Seat, SeatLock>> lockedSeats;

    @Override
    public List<Seat> getLockedSeat(Show show) {
        List<Seat> seats=new ArrayList<>();

        if(!lockedSeats.containsKey(show)){
            return seats;
        }
        for(Map.Entry<Seat, SeatLock> ee:lockedSeats.get(show).entrySet()){
            if(checkExpiry(ee.getValue().getLockedTime())){
                seats.add(ee.getKey());
            }
        }


        return seats;
    }


    @Override
    public boolean lockSeats(Show show, List<Seat> seats) {
        Collections.sort(seats);
        List<Seat> lockedNow=new ArrayList<>();
        for(Seat seat:seats){
            synchronized (seat){
                lockedSeats.putIfAbsent(show, new ConcurrentHashMap<>());
                if(lockedSeats.get(show).containsKey(seat)){
                    SeatLock currLock=lockedSeats.get(show).get(seat);
                    if(!checkExpiry(currLock.getLockedTime())){
                        unlockSeats(show, lockedNow);
                        return false;
                    }
                }
                lockedSeats.get(show).put(seat, new SeatLock(show, seat, now()));
                lockedNow.add(seat);
            }
        }
        return true;
    }

    //You can use the observer pattern where you will store the user who requested a seat lock. and then from this method you can call the notify to notify them.
    @Override
    public boolean unlockSeats(Show show, List<Seat> seats) {
        Collections.sort(seats);
        for(Seat seat:seats){
            synchronized (seat){
                if(lockedSeats.containsKey(show)){
                   lockedSeats.get(show).remove(seat);
                }
            }
        }
        return true;
    }

    private boolean checkExpiry(LocalDateTime time){
        /*
        Add logic of accepting if time is more than 5 minute old than now
         */
        return time.plusMinutes(5).isAfter(LocalDateTime.now());
    }

}
