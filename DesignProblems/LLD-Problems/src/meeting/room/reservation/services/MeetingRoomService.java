package services;

public class MeetingRoomService{
    
    private RoomReservationDao roomReservationDao;

    public MeetingRoomService(RoomReservationDao roomReservationDao){
        this.roomReservationDao=roomReservationDao;
    }

    List<RoomInfo> getAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime, Integer capacity){
            
    }
}