package parking.lot.system.Entities;

import parking.lot.system.enums.VehicleType;

public class Slot {
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    VehicleType vehicleType;
}
