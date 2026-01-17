package parking.lot.system.Entities;

import java.time.LocalDateTime;

public class SlotVehicleMapping {
    public SlotVehicleMapping(Slot slot, Vehicle vehicle, LocalDateTime dateTime) {
        this.slot = slot;
        this.vehicle = vehicle;
        this.dateTime = dateTime;
    }

    Slot slot;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    Vehicle vehicle;
    LocalDateTime dateTime;


}
