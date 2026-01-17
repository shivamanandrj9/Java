[//]: # (This is just the implementation of the learning. Practice will be done on some other problems.)


Requirements:

1. User will be able to search for a movie.
2. Now based on the movie, they can choose the theatre.
3. 1 theatre can have multiple screens and each screen can have multiple seats.
4. Now we can have a show playing on a screen which will be basically a movie having some timing for which it will be played.
5. They can select multiple seats and then proceed for the payment. 
6. There will be a window for which the seat will be reserved for the current user and other users won't be able to book those seats.
7. Once the payment is successful, those seats will be booked.
8. We won't be showing the seats that are locked or booked to a user.


Scoping out:
1. Seats can have multiple category.

Enhancements:
1. Let's say user A selected a seat but as soon as it clicked on the payment page, the seat was booked or locked by then. We will notify the user in case of cancellation or timeout failure etc.



**Entity:**

User:
{
    String userId;
    String name;
    String address;
}

Movie:
{
    String MovieName;
    double rating;
}

Theatre:
{
    String theatreId;
}

Screen:
{
    String screedId;
    Theatre theatreId;
}

Seat:
{
    String seatId;
    Screen screen;
    // We can't directly add the status here as same seat can be used in multiple shows, hence we have created Booking entity
}

Show:
{
    Screen screen;
    Movie movie;
    DateTime startTime;
    DateTime endTime;
}

SeatLock:
{
    Seat seat;
    Show show;
    ReentrantLock lock;
    DateTime lockedTime;
}

Booking:
{
    Seat seat;
    Show show;
}



**Controller:**
PaymentController
{
    boolean pay(PaymentMethod method) {...};
}

BookingController
{
    boolean bookSeat(List<Seat> seats, String userId){...};
    List<Seat> getBookedSeats(Show show);
}

ScreenController
{
    List<Screen> findScreens(Theatre theatre);
}

TheatreController
{
    List<Theatre> findTheatres(Movie movie);
}

ShowController
{
    List<Show> findShows(Screen screen);
}

SeatController
{
    List<Seats> findAvailableSeats(Show show);
}

**Service:**
PaymentService
{
    boolean pay(PaymentMethod method) {...};
}

BookingService
{
    boolean bookSeat(List<Seat> seats, String userId){...};
}

SeatService
{
    List<Seat> getAvailableSeats(Show show){...};
}




**Enum:**
PaymentMethod
{
    UPI, CARD
}

**Interface:**
IPaymentStrategy
{
    boolean pay(double amount);
}

ILockManager
{
    List<Seat> getLockedSeats(Show show);
    boolean lockSeats(List<Seat> seats);
    boolean unlockSeats(List<Seat> seats);
}

**PaymentStrategyImpl**
UPIPayment implements PaymentStrategy
{
    boolean pay(double amount) {...};
}

CardPayment implements PaymentStrategy
{
    boolean pay(double amount) {...};
}

**LockManagerImpl**
BasicLockManager implements ILockManager
{
    ConcurrentHashMap<Seat, SeatLock>  lockedSeats;

    List<Seat> getLockedSeats(Show show){...};
    boolean lockSeats(List<Seat> seats){...};
    boolean unlockSeats(List<Seat> seats){...};
}










