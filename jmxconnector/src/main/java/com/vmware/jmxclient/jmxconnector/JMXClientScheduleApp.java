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

    @Scheduled(fixedRate = 10000)
    //@Scheduled(initialDelay = 1000 * 30, fixedDelay=Long.MAX_VALUE, timeUnit = TimeUnit.NANOSECONDS )
    public void schedulePersonUpdateAsync() {
        try {
            /*final JMXServiceURL u = new JMXServiceURL(
                    "service:jmx:rmi:///jndi/rmi://" + hostName + ":" + portNum + "/jmxrmi");
           // final JMXConnector c = JMXConnectorFactory.connect(u);
            final Registry registry = LocateRegistry.getRegistry("jmxdemo-app",9090);
            //final MBeanServerConnection mBeanServerConnection = c.getMBeanServerConnection();
            final MBeanServerConnection mBeanServerConnection = (MBeanServerConnection)
                    registry.lookup("org.springframework.boot:type=Endpoint,name=Info");
            final ObjectName objectName =// new ObjectName("org.springframework.boot:type=Endpoint,name=Configprops");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Env");
            //new ObjectName("org.springframework.boot:type=Endpoint,name=Health");
            new ObjectName("org.springframework.boot:type=Endpoint,name=Info");
            if (mBeanServerConnection.isRegistered(objectName)) {
                System.out.println("Bean is registered");
            } else {
                System.out.println("Bean is not registered");
            }
            Object result = mBeanServerConnection.invoke(objectName, //"configurationProperties",
                   // "environment",
                   // "health",
                    "info",
                    new Object[0], new String[0]);
            System.out.println("Invoking JMX method - " + result);*/
            //c.close();
            // Define the JMX service URL
            JMXServiceURL url = new
                    JMXServiceURL("service:jmx:rmi:///jndi/rmi://10.96.84.67:9090/jmxrmi");

            // Connect to the JMX server
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

            // Get an MBeanServerConnection
            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

            // Construct the ObjectName for the MBean you want to access
            ObjectName mbeanName = new ObjectName("java.lang:type=OperatingSystem");

            // Invoke an operation on the MBean (for example, get the system load average)
            double loadAverage = (double) mbsc.getAttribute(mbeanName, "SystemLoadAverage");
            final ObjectName objectName =// new ObjectName("org.springframework.boot:type=Endpoint,name=Configprops");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Env");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Health");
                    new ObjectName("org.springframework.boot:type=Endpoint,name=Info");
            System.out.println("System load average: " + loadAverage);

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
