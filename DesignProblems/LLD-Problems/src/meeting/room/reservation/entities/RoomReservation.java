package entities;

public class RoomReservation{

    /*
    Just making it public here just to make the code runnable and don't have to implement the getter and setter. It will be private in the actual builder implementation example.
     */
    public Integer id;
    public Integer roomId;
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
    public Boolean isActive;
    public Integer userId;

    RoomReservation(RoomReservationBuilder roomReservationBuilder)
    {
        this.id=roomReservationBuilder.id;
        this.roomId=roomReservationBuilder.roomId;
        this.date=roomReservationBuilder.date;
        this.startTime=roomReservationBuilder.startTime;
        this.endTime=roomReservationBuilder.endTime;
        this.isActive=roomReservationBuilder.isActive;
        this.userId=roomReservationBuilder.userId;
    }

    public static RoomReservationBuilder builder()
    {
        return new RoomReservationBuilder();
    }

    public static class RoomReservationBuilder 
    {
        private Integer id;
        private Integer roomId;
        private LocalDate date;
        private LocalTime startTime;
        private LocalTime endTime;
        private Boolean isActive;
        private Integer userId;

        public RoomReservationBuilder id(Integer id)
        {
            this.id=id;
            return this;
        }

        public RoomReservationBuilder roomId(Integer roomId)
        {
            this.roomId=roomId;
            return this;
        }

        public RoomReservationBuilder date(LocalDate date)
        {
            this.date=date;
            return this;
        }

        public RoomReservationBuilder startTime(LocalTime startTime)
        {
            this.startTime=startTime;
            return this;
        }

        public RoomReservationBuilder endTime(LocalTime endTime)
        {
            this.endTime=endTime;
            return this;
        }

        public RoomReservationBuilder isActive(Boolean isActive)
        {
            this.isActive=isActive;
            return this;
        }

        public RoomReservationBuilder userId(Integer userId)
        {
            this.userId=userId;
            return this;
        }

        public RoomReservation build(){
            return new RoomReservation(this);
        }

    }
}