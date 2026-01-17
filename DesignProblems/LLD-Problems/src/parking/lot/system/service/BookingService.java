package parking.lot.system.service;



//BookingService
//{
//    ConcurrentHashMap<VehicleType, SlotVehicleMapping> bookings;
//
//    boolean isSlotAvailable(VehicleType vechicleType){...};
//
//    Slot bookSlot(VehicleType vehicleType){...};
//
//    double findPrice(Vehicle vehicle);
//
//    boolean freeSlot(Vehicle vehicle);
//}

import parking.lot.system.Entities.*;

import java.util.*;

import static java.time.LocalDateTime.now;

public class BookingService {

    HashMap<VehicleType, HashMap<Vehicle,SlotVehicleMapping>> bookings;
    SlotService slotService;

    /*
    TODO: Define constructor
     */

    boolean isSlotAvailable(VehicleType vehicleType){
        int totalSlots=slotService.getSlotCount();
        int bookedSlots=bookings.get(vehicleType).size();

        return totalSlots>bookedSlots;
    }

    synchronized Slot bookSlot(Vehicle vehicle){
        VehicleType vehicleType=vehicle.getVehicleType();
        List<Slot> allSlots=slotService.getSlots(vehicleType);
        List<Slot> occupiedSlotsForVehicle=new ArrayList<>();
        HashMap<Vehicle,SlotVehicleMapping> occupiedSlots = bookings.get(vehicleType);
        for(Map.Entry<Vehicle,SlotVehicleMapping> e:occupiedSlots.entrySet()){
            if(e.getValue().getSlot().getVehicleType()==vehicleType){
                occupiedSlotsForVehicle.add(e.getValue().getSlot());
            }
        }

        allSlots.remove(occupiedSlotsForVehicle);
        Slot picked=occupiedSlotsForVehicle.get(0);

        SlotVehicleMapping slotVehicleMapping=new SlotVehicleMapping(picked, vehicle, now());

        bookings.putIfAbsent(vehicleType, new HashMap<Vehicle, SlotVehicleMapping>());
        bookings.get(vehicleType).putIfAbsent(vehicle,slotVehicleMapping);
        return picked;
    }

    double findPrice(Vehicle vehicle){
        /*
        It will get the slotVehicleMappingand then it will fnd the in time and then find diff and then give the price
         */
        return 0;
    }

    synchronized boolean freeSlot(Vehicle vehicle){
        /*
        It will just remove that vehicle key from the bookings.
         */
        return true;
    }

}
