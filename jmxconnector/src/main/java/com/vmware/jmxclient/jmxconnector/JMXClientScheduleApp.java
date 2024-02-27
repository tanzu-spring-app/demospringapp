package com.vmware.jmxclient.jmxconnector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;


@Component
public class JMXClientScheduleApp {
    @Value("${rmi.host}")
    String hostName;
    @Value("${rmi.port}")
    String portNum;

    public JMXClientScheduleApp() throws MalformedURLException {
    }

    //@Scheduled(fixedRate = 10000)
    //@Scheduled(initialDelay = 1000 * 30, fixedDelay=Long.MAX_VALUE, timeUnit = TimeUnit.NANOSECONDS )
    @Scheduled(fixedRate = 3600000, initialDelay = 0)
    public void schedulePersonUpdateAsync() {
        try {
            // Define the JMX service URL
            final JMXServiceURL url = new JMXServiceURL(
                    "service:jmx:rmi:///jndi/rmi://" + hostName + ":" + portNum + "/jmxrmi");
            // Connect to the JMX server
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

            // Get an MBeanServerConnection
            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

            final ObjectName objectName =// new ObjectName("org.springframework.boot:type=Endpoint,name=Configprops");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Env");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Health");
                    new ObjectName("org.springframework.boot:type=Endpoint,name=Info");

            Object result = mbsc.invoke(objectName, //"configurationProperties",
                    // "environment",
                    // "health",
                    "info",
                    new Object[0], new String[0]);
            System.out.println("Invoking JMX method - " + result);

            // Close the connection
            jmxc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
