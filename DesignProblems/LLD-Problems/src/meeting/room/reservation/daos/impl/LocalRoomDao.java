package daos.impl;


public class LocalRoomDao implements RoomDao{

    private List<Room> rooms;

    public LocalRoomDao(List<Room> rooms){
        this.rooms=rooms;
    }

    public List<Room> fetchAll(){
        return this.rooms;
    }
}