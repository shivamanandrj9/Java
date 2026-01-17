package movie.ticket.booking.Interfaces;


//ILockManager
//{
//    List<Seat> getLockedSeats(Show show);
//    boolean lockSeats(List<Seat> seats);
//    boolean unlockSeats(List<Seat> seats);
//}

import movie.ticket.booking.Entities.Seat;
import movie.ticket.booking.Entities.Show;

import java.util.List;

public interface ILockManager {
    List<Seat> getLockedSeat(Show show);
    boolean lockSeats(Show show, List<Seat> seats);
    boolean unlockSeats(Show show, List<Seat> seats);
}
