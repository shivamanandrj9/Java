Problem Statement:
Design a parking lot system.

Requirements:
1. There will be different slots based on vehicle type (bike, car, truck)
2. Each vehicle will be assigned some slot in the parking.
3. We will be registering in-time for all the vehicles that will be passing through.
4. When they leave, we will note down what time they spent in the parking and based on that they will be charged.
5. If the parking space is not available they will not be allowed until there is some space.
6. Multiple entry points then we will have to be careful about the race conditions. 


Scope out:
1. Ignore the floors for now. Let's have 


**Entities**

Slot
{
   VehicleType vehicleType;
}

Vehicle
{
    String vehicleNumber;
    VehicleType vehicleType;
}

SlotVehicleMapping
{
    Slot slot;
    Vehicle vehicle;
    DateTime inTime;
}





**Enums**

VehicleType
{
    BIKE, CAR, TRUCK
}

Status
{
    OCCUPIED, FREE
}

PaymentMethod
{
    UPI, CASH;
}


**Controller**
SlotController
{
    
}

BookingController
{
    
    
}



**Service**
SlotService
{
    List<Slot> slots;
    
    List<Slot> getSlots(VehicleType vehicleType){...}
    boolean createSlot(){...}
}


BookingService
{
    ConcurrentHashMap<VehicleType, SlotVehicleMapping> bookings;
    
    boolean isSlotAvailable(VehicleType vechicleType){...};

    Slot bookSlot(VehicleType vehicleType){...};
        
    double findPrice(Vehicle vehicle);

    boolean freeSlot(Vehicle vehicle);
}



PaymentService
{
    boolean pay(double amount, PaymentMethod paymentMethod){...};
}


**Interface**

PaymentStrategy
{
    boolean pay(double amount);
}

**PaymentStrategyImpl**

CardPaymentStrategy
{
    boolean pay{....}
}

UPIPaymentStrategy
{
boolean pay{....}
}

**Registry**
PaymentRegistry
{
    HashMap<PaymentMethod, PaymentStrategy> paymentMethods;

    PaymentStrategy getPaymentStrategy(PaymentMethod method){...};
}







