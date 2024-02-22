package com.example.springboot.admin.client2;

import com.example.springboot.admin.client2.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Optional<Student> findByFirstName(String name);
}
