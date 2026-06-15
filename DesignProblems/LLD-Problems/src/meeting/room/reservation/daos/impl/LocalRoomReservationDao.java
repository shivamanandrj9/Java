package daos;

public class LocalRoomReservationDao implements RoomReservationDao {

    List<RoomReservation> roomReservations;
    
    public LocalRoomReservationDao(){
        this.roomReservations=new ArrayList<>();
    } 

    public Integer insert(RoomReservation roomReservation){
        this.roomReservations.add(roomReservation);
    }

    public Boolean isRoomAvailable(Integer roomId, LocalDate date, LocalTime startTime, LocalTime endTime){
        Boolean flag=Boolean.TRUE;
        for(RoomReservation reservation: this.roomReservations){
            if(reservation.getDate().equals(date) && !((reservation.getEndTime().compareTo(startTime))<0 && (endTime.compareTo(reservation.getStartTime()))<0)){
                flag=Boolean.FALSE;
            }
        }
        return flag;
    }

}