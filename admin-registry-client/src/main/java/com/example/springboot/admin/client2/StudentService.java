package com.example.springboot.admin.client2;

import com.example.springboot.admin.client2.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseGet(Student::new);
    }

    public Student getStudentByFirstName(String firstName) {
        Optional<Student> student = studentRepository.findByFirstName(firstName);
        return student.orElseGet(Student::new);
    }

    public void addStudent(final String firstName,
                           final String lastName,
                           final String city,
                           final int standard) {
        Student student = new Student(firstName, lastName, city, standard);
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
