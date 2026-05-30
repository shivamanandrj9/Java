# Problem Statement

Design a meeting room reservation platform that allows employees in an organization to book rooms for meetings, check availabiliity and manage bookings.

# System Requirements

1. An employee can check for the (date, timeSlot, capacity), what all meeting rooms that are available.
2. Employee can then go ahead and select the meeting room which they want to book.
3. They can cancel an existing meeting.
4. System should handle overlapping requests gracefully.
5. For a meeting room the admin should be able to see all the meetings that are scheduled in that room.

# Concurrency Aspect

1. Two person trying to book overlapping should not be able to book it. One of them will fail to do so.


# Entities

1. Room
    - id: Integer
    - name: String (Unique)
    - capacity: Integer

2. Employee
    - id: Integer
    - name: String
    - email: String

3. RoomReservation
    - id: Integer
    - roomId: FK
    - date: LocalDate
    - startTime: LocalTime
    - endTime: LocalTime
    - isActive: Boolean
    - userId: FK

# Services

1. MeetingRoomService
    1. List<RoomInfo> getAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime, Integer capacity);
    
2. BookingService
    1. Integer bookRoom(Integer roomId, Integer userId, LocalTime startTime, LocalTime endTime, LocalDate date) 
    2. Integer cancelBooking(Integer userId, Integer bookingId)
    3. List<UserBookingInfo> getUserBookingInfo(Integer userId)
    4. List<RoomBookingStatus> getRoomBookingStatus(Integer roomId, Integer userId)

# LockingManagers

1. BookingLockingInterface
    1. void acquireLock(LocalDate date, Integer roomId);
    2. void releaseLock(LocalDate date, Integer roomId);

# Models

1. RoomInfo
    - roomId
    - roomName
    - capacity

2. UserBookingInfo
    - bookingId
    - roomName
    - date
    - startTime
    - endTime

3. RoomBookingStatus
    - bookingId
    - date
    - startTime
    - endTime
    - userId








