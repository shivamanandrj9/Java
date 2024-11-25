package jmx;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SimpleMBeanServer {

    public static void main(String[] args)
            throws Exception {

        // Create a new MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        // Create an "ObjectName" which contains the package name and name of the MBean
        ObjectName objectName = new ObjectName("com.myexample.jmx:type=Dog");
        // Create an instance of our Dog MBean
        Dog dogMBean = new Dog();
        // Register our Dog MBean with our MBean Server
        mbs.registerMBean(dogMBean, objectName);

        System.out.println("Custom MBean Server starting up...");
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE); // Keeps our MBean Server process alive
    }
}

