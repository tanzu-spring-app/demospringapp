package com.example.demo;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    @Scheduled(fixedRate = 20000)
    public void schedulePersonUpdateAsync()  {
        final Person p = personService.get(1L);
        p.setNumberOfCards(p.getNumberOfCards()%10+1);
        personService.update(p);
        System.out.println("Setting card number for person update - " + p);
    }


}
