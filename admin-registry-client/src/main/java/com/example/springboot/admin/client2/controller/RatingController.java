package com.example.springboot.admin.client2.controller;

import com.example.springboot.admin.client2.StudentService;
import com.example.springboot.admin.client2.entities.Rating;
import com.example.springboot.admin.client2.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/get")
    public Rating getRating() {
        Random random = new Random();
        int answer = random.nextInt(10 + 1);
        return new Rating("Movie1", answer);
    }

    @GetMapping("/student/{id}")
    public Student getStudentWithId(@PathVariable("id") final int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public void addNewStudent(@RequestParam("firstName") final String firstName,
                              @RequestParam("lastName") final String lastName,
                              @RequestParam("city") final String city,
                              @RequestParam("standard") final int standard) {
        studentService.addStudent(firstName, lastName, city, standard);
    }
}
