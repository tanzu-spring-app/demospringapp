package com.middle.middle.voyager;

import com.middle.middle.voyager.entity.Employee;
import com.middle.middle.voyager.entity.Student;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MiddleController {

    @Autowired
    private MiddleService middleService;

    @GetMapping(path = "/")
    @Hidden
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui-custom.html");
    }

    @GetMapping(path = "/middle/students")
    public List<Student> getStudents() {
        return middleService.getStudents();
    }

    @PostMapping(path = "middle/message/student")
    public void messageStudent() {
        middleService.messageStudent();
    }

    @GetMapping(path = "/middle/employees")
    public List<Employee> getEmployees() {
        return middleService.getEmployees();
    }

    @GetMapping(path = "/read/message")
    public String readMessage() {
        return middleService.readMessage();
    }
}
