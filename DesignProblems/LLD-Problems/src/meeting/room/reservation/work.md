# Problem Statement

Desing a meeting room booking system

# System Requirements

1. There will be some fixed set of meeting rooms. 
2. Every room will have some capacity. 
3. A user trying to book a room will request with the number of person they are trying to accomodate and the time slot for which they want the room.
4. If there are multiple rooms available satisfying the criteria, we would go via this
    - Find the one with minimum extra space as requested.
    - Find the lexicographically smallest one.
5. Once booked, user will be notified. 
6. User can cancel it anytime.
7. User can reschedule the meeting.

# Entities

1. Room
    - id: Integer
    - name: String
    - capacity: Integer

2. User
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
