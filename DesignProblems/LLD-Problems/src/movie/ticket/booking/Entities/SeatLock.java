package movie.ticket.booking.Entities;

//SeatLock:
//        {
//Seat seat;
//Show show;
//ReentrantLock lock;
//DateTime lockedTime;
//}

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class SeatLock {
    public SeatLock(Show show, Seat seat, LocalDateTime lockedTime) {
        this.show = show;
        this.seat = seat;
        this.lockedTime = lockedTime;
    }

    public Show show;
    public Seat seat;
    LocalDateTime lockedTime;

    public Seat getSeat(){
        return this.seat;
    }

    public Show getShow(){
        return this.show;
    }

    public LocalDateTime getLockedTime(){
        return this.lockedTime;
    }

}
