package com.vmware.jmxclient.jmxconnector;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.net.MalformedURLException;

@Component
public class JMXClientScheduleApp {
    final String hostName = "localhost"; //Host name of the remote JMX application
    final String portNum = "9090";  //Remote RMI port
    final JMXServiceURL u = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + hostName + ":" + portNum + "/jmxrmi");

    public JMXClientScheduleApp() throws MalformedURLException {
    }

    @Scheduled(fixedRate = 10000)
    public void schedulePersonUpdateAsync() {
        try {
            final JMXConnector c = JMXConnectorFactory.connect(u);
            MBeanServerConnection mBeanServerConnection = c.getMBeanServerConnection();
            ObjectName objectName = //new ObjectName("org.springframework.boot:type=Endpoint,name=Configprops");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Env");
                    //new ObjectName("org.springframework.boot:type=Endpoint,name=Health");
                    new ObjectName("org.springframework.boot:type=Endpoint,name=Info");
            if (mBeanServerConnection.isRegistered(objectName)) {
                System.out.println("Bean is registered");
            } else {
                System.out.println("Bean is not registered");
            }
            Object result = mBeanServerConnection.invoke(objectName,
                    //"configurationProperties",
                    // "environment",
                    // "health",
                    "info",
                    new Object[0], new String[0]);
            System.out.println("JMX method response -  " +result);
            c.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
