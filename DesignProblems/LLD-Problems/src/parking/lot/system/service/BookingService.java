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
import parking.lot.system.enums.VehicleType;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.time.LocalDateTime.now;

public class BookingService {

    ConcurrentHashMap<VehicleType, ConcurrentHashMap<Vehicle,SlotVehicleMapping>> bookings=new ConcurrentHashMap<>();
    ConcurrentHashMap<VehicleType,ConcurrentLinkedQueue<Slot>> availableSlots=new ConcurrentHashMap<>();

    SlotService slotService=new SlotService();

    /*
    TODO: Define constructor
     */

    boolean isSlotAvailable(VehicleType vehicleType){
        availableSlots.computeIfAbsent(vehicleType, k ->{
            ConcurrentLinkedQueue<Slot> freeSlots=new ConcurrentLinkedQueue<>();
            freeSlots.addAll(slotService.getSlots(vehicleType));
            return freeSlots;
        });
        return !availableSlots.get(vehicleType).isEmpty();
    }

    Slot bookSlot(Vehicle vehicle){
        VehicleType vehicleType=vehicle.getVehicleType();
        availableSlots.computeIfAbsent(vehicleType, k ->{
            ConcurrentLinkedQueue<Slot> freeSlots=new ConcurrentLinkedQueue<>();
            freeSlots.addAll(slotService.getSlots(vehicleType));
            return freeSlots;
        });

        Slot picked=availableSlots.get(vehicleType).poll();
        if(picked==null){
            throw new InvalidStateException("No available slot");
        }
        bookings.putIfAbsent(vehicleType, new ConcurrentHashMap<>());
        SlotVehicleMapping booked = bookings.get(vehicleType).putIfAbsent(vehicle,new SlotVehicleMapping(picked, vehicle,now()));
        return (booked==null)?picked:booked.getSlot();
    }

    double findPrice(Vehicle vehicle){
        /*
        It will get the slotVehicleMappingand then it will fnd the in time and then find diff and then give the price
         */
        return 0;
    }

    boolean freeSlot(Vehicle vehicle) throws IllegalAccessException {
        VehicleType vehicleType=vehicle.getVehicleType();
        Slot occupiedSlot=null;
        SlotVehicleMapping removedMapping=null;
        if(!bookings.containsKey(vehicleType)){
            throw new IllegalAccessException("Vehicle not found");
        } else{
            SlotVehicleMapping previouslyMapping=bookings.get(vehicleType).get(vehicle);
            if(previouslyMapping==null){
                throw new IllegalAccessException("Vehicle not found");
            }
            occupiedSlot=previouslyMapping.getSlot();
            removedMapping = bookings.get(vehicleType).remove(vehicle);
        }


        if(!availableSlots.containsKey(vehicleType) || availableSlots.get(vehicleType).contains(occupiedSlot)){
            throw new IllegalAccessException("Vehicle not found");
        } else{
            if(removedMapping!=null){
                availableSlots.get(vehicleType).add(occupiedSlot);
            }
        }
        return true;
    }

}
