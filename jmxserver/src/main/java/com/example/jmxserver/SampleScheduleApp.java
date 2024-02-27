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
public class SampleScheduleApp {
    @Autowired
    private PersonService personService;

    @Async
    // @Scheduled(fixedRate = 20000)
    @Scheduled(initialDelay = 1000 * 30, fixedDelay = Long.MAX_VALUE, timeUnit = TimeUnit.NANOSECONDS)
    public void schedulePersonUpdateAsync() throws IOException, InterruptedException {
        System.out.println("JMX server started on port 9090");
        final Person p = personService.get(1L);
        p.setNumberOfCards(p.getNumberOfCards() % 10 + 1);
        personService.update(p);
        System.out.println("Setting card number for person update - " + p);
    }


}
