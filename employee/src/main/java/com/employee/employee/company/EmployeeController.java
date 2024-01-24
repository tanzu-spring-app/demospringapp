package com.employee.employee.company;

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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeWithId(@PathVariable("id") final int id) {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/employee")
    public void addNewEmployee(@RequestParam("firstName") final String firstName,
                              @RequestParam("lastName") final String lastName,
                              @RequestParam("city") final String city,
                              @RequestParam("designation") final String designation) {
        employeeService.addEmployee(firstName, lastName, city, designation);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
