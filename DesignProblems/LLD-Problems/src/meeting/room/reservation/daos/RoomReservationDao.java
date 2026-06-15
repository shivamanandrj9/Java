package daos;

public interface RoomReservationDao {
    public Integer insert(RoomReservation roomReservation);
    public Boolean isRoomAvailable(Integer roomId, LocalDate date, LocalTime startTime, LocalTime endTime);
}