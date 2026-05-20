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
    - name: String
    - capacity: Integer

2. Employee
    - id: Integer
    - name: String
    - email: String

3. RoomReservation
    - id: Integer
    - roomId: FK
    - date: String
    - startTime: String
    - endTime: String
    - isActive: Boolean
    - userId: FK





