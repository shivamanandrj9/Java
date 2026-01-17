package parking.lot.system.service;

import parking.lot.system.Entities.Slot;
import parking.lot.system.Entities.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class SlotService {
    List<Slot> slots;

    int getSlotCount(){
        return slots.size();
    }

    List<Slot> getSlots(VehicleType vt){
        List<Slot> totalSlots=new ArrayList<>();
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).getVehicleType()==vt){
                totalSlots.add(slots.get(i));
            }
        }
        return totalSlots;
    }
}
