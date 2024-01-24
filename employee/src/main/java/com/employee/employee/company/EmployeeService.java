package com.employee.employee.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseGet(Employee::new);
    }

    public void addEmployee(final String firstName,
                           final String lastName,
                           final String city,
                           final String designation) {
        Employee employee = new Employee(firstName, lastName, city, designation);
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
