package com.example.demo.services.impl;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("No person found for id "+id));
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

}
