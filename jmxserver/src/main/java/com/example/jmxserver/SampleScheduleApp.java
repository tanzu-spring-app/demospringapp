package com.example.demo;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;
import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
@Component
@EnableAsync
public class SampleScheduleApp
{
    @Autowired
    private PersonService personService;

  /*  @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println(
                "Fixed rate task async - " + System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }
*/
    @Async
   // @Scheduled(fixedRate = 20000)
    @Scheduled(initialDelay = 1000 * 30, fixedDelay=Long.MAX_VALUE, timeUnit = TimeUnit.NANOSECONDS )
    public void schedulePersonUpdateAsync() throws IOException, InterruptedException {
       /* System.out.print("com.sun.management.jmxremote.localConnectorAddress: "+
                System.getProperty("com.sun.management.jmxremote.localConnectorAddress"));
        // Get the hostname of the server
        String hostname = java.net.InetAddress.getLocalHost().getHostAddress();

        // Print the RMI service URL
        System.out.println("RMI service is running at rmi://" + hostname);


*/

        // Create an MBeanServer
        /*MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Create an RMI registry on port 9090
        LocateRegistry.createRegistry(9090);
        // Construct the JMXServiceURL
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://0.0.0.0:9090/jmxrmi");

        // Create and start the JMXConnectorServer
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        cs.start();*/

        // Keep the server running
        //Thread.sleep(Long.MAX_VALUE);
       /* final Person p = personService.get(1L);
        p.setNumberOfCards(p.getNumberOfCards()%10+1);
        personService.update(p);
        System.out.println("Setting card number for person update - " + p);*/

        System.out.println("JMX server started on port 9090");

    }


}
