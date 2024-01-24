package com.studentdb.student.school.student;

import com.studentdb.student.school.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudentWithId(@PathVariable("id") final int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/{name}")
    public Student getStudentWithId(@PathVariable("name") final String name) {
        return studentService.getStudentByFirstName(name);
    }

    @PostMapping("/student")
    public void addNewStudent(@RequestParam("firstName") final String firstName,
                              @RequestParam("lastName") final String lastName,
                              @RequestParam("city") final String city,
                              @RequestParam("standard") final int standard) {
        studentService.addStudent(firstName, lastName, city, standard);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
