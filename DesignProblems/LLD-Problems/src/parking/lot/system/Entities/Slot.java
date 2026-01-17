package parking.lot.system.Entities;

public class Slot {
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    VehicleType vehicleType;
}
