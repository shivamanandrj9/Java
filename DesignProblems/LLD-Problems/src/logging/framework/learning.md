1. The Logger class should have a common private method which accepts the LogLevel depending on which method of that class say error, info etc has called it. 


2. Appenders should not be configured inside the logger constructor. Better design is to have a registry where you will have a map. Map<LogLevel, List<Appender>> routingMap. Handler constructor like the ErrorHandler constructor will call get the List of appenders in this routing map and should add it to its listeners. 

3. Also make the logger singleton. (Implement one of the class as singleton to show this design pattern)

# Concurrency:

1. Current implementation have problem if one thread adds the listerner and while other thread is reading it using an iterator(for each loop), it will cause the Concurrent exception. Better to use CopyOnWriteArrayList.

2. 