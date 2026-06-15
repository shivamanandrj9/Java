package daos;

public class LocalRoomReservationDao implements RoomReservationDao {

    List<RoomReservation> roomReservations;
    RoomDao roomDao;
    
    public LocalRoomReservationDao(List<RoomReservation> roomReservations, RoomDao roomDao){
        this.roomReservations=roomReservations;
        this.roomDao=roomDao;
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

    public List<Room> getAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime, Integer capacity){
        Set<Integer> overlappingRoomIds=new HashSet<>();
        for(RoomReservation roomReservation: this.roomReservations){
            if(!(roomReservation.date==date && roomReservation.isActive==Boolean.TRUE)) return;
            if(endTime.compareTo(roomReservation.startTime)==-1 || roomReservation.endTime.compareTo(startTime)==-1) return;
            overlappingRoomIds.add(roomReservation.id);
        }

        List<Room> allRooms=this.roomDao.fetchAll();

        /*
        Check if there is any better way
         */

        List<Room> availableRooms;

        for(Room room: allRooms){
            if(!overlappingRoomIds.contains(room.id) && room.capacity>=capacity){
                availableRooms.add(room);
            }
        }
        return availabelRooms;

    }

    public Integer id;
    public Integer roomId;
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
    public Boolean isActive;
    public Integer userId;

}