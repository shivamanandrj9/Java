# Problem Statement

Design and implement a flexible and extensible logging framework that can be used by applications to log messages at different levels (INFO, DEBUG, ERROR etc), support multiple output destination (console, file., etc.) and allow for custom formatting of log messages.

# Functional Requirements

1. There can be multiple levels of logs like INFO, ERROR, DEBUG, and it should be extensible.
2. We will also have multiple appenders i.e. where we want to output the logs (console, file, etc). This should be extensible too. 
3. These appenders will be on the basis of the log level. i.e INFO Logs -> On console, DEBUG Logs -> Console + File, ERROR Logs -> Console + File. This should also be extensible.
4. Concurrency should be handled, i.e. two threads trying to print some logs at the same time should not corrupt the data.
5. Logger can be called something like something like 'log.error("The message");. This will print the message as [<<DateTime>>] [<<LogType>>] <<LogMessage>>

# entities

1. Log
    - datetime: DateTime
    - message: String
    - logLevel: LogLevel

# handlers

1. <<LogHandler>> extends Subject<T>
    - void handle(Log log)

2. impl
    1. InfoHandler
        - LogHandler next;
        - void handle(Log log) {...};
    
    2. DebugHandler

    3. ErrorHandler

# manager

1. Logger

    - LogHandler head;

    - void error(String message) {...}
    - void debug(String message) {...}
    - void info(String message) {...}

# appenders

1. <<Appender>> extends Observer<T>
    - void append(Log log)

2. impl
    1. ConsoleAppender
        - synchronized void append(Log log) {...}

    2. FileAppender



# Enums

1. LogLevel
    - INFO
    - ERROR
    - DEBUG

# Interfaces

1. Observer<T>
    - notify(T data)

2. Subject<T>
    - List<Observer<T>> listeners;
    - notifyAll(T data);
    - subscribe(Observer<T>)
    - unsubscribe(Observer<T>)
