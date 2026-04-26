package logging.framework;

import logging.framework.managers.Logger;

public class Main {

    public static void main(String[] args) {

        Logger log = new Logger();

        log.info("This is an informational log");
        System.out.println("======EOL=====");
        log.error("This is an error log");



    }
}
