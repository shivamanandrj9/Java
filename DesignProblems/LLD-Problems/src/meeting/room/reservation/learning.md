# Data types

1. DateTime Related datatypes
    - Is it okay to use String in an interview. -> No, you will have to handle cases and validity checks.
    - use LocalDate, LocalTime -> methods that can be used are (LocalTime.now(), LocalTime.plusSeconds(), LocalTime.minusSeconds(), LocalTime.compareTo(). Similar for the date as well.)

2. primitive vs non primitive
    - For the entity definition, use Integer etc because since these fields will be auto increment and we would like to pass this as NULL so that db automatically assigns them a value.
    - For the service method, use Integer only so that you do a null check if the id is required and it has not been provided intead of assigning it a default value and messing the logic.

# WHAT IF?

2. If someone does not get any meeting room, our system notifies if the requirement is met.
3. How will the synchronization will work at DB level.