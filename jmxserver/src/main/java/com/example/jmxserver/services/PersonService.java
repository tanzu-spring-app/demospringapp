package com.example.demo.services;

import com.example.demo.entities.Person;

import java.util.List;

public interface PersonService {

    Person add(Person quiz);

    List<Person> getAll();

    Person get(Long id);

    Person update(Person quiz);

}
