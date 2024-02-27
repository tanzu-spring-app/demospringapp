package com.example.demo.controller;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public String getPerson(){
        final Person p = personService.get(1L);
        p.setNumberOfCards(p.getNumberOfCards()%10+1);
        personService.update(p);
        System.out.println("Setting card number for person update - " + p);
        return p.getNumberOfCards()+"";
    }
}
