package parking.lot.system.Entities;

import parking.lot.system.enums.VehicleType;

public class Vehicle {
    VehicleType vehicleType;
    String vehicleNumber;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;
        return vehicle.vehicleNumber.equals(this.vehicleNumber);
    }
}
