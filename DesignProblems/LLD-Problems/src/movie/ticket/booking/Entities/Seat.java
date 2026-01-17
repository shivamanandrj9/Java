package movie.ticket.booking.Entities;

import movie.ticket.booking.Enums.SeatStatus;

public class Seat implements Comparable<Seat> {

    public String getSeatId() {
        return seatId;
    }

    String seatId;
    Screen screen;

    @Override
    public int compareTo(Seat o) {
        return this.seatId.compareTo(o.getSeatId());
    }
}
