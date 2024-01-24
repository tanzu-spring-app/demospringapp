package com.studentdb.student.school.student;

import com.studentdb.student.school.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Optional<Student> findByFirstName(String name);
}
