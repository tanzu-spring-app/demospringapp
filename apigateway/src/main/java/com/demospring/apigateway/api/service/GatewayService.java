package com.demospring.apigateway.api.service;

import com.demospring.apigateway.entity.Employee;
import com.demospring.apigateway.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GatewayService {

    @Value("${demospring.student.url}")
    private String studentUrl;

    @Value("${demospring.employee.url}")
    private String employeeUrl;

    @Value("${demospring.feignclient.url}")
    private String feignClientUrl;

    @Value("${demospring.messaging.url}")
    private String messagingUrl;

    private RestTemplate restTemplate;

    public GatewayService() {
        this.restTemplate = new RestTemplate();
    }

    public Employee getEmployee() {
        String url = employeeUrl + "/employees";
        List<Employee> result = restTemplate.getForObject(url, List.class);
        if (result == null || result.isEmpty()) {
            return new Employee();
        }
        int last = result.size() -1;
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(result.get(last), Employee.class);
    }

    public Student getStudent() {
        List<Student> result = getStudents();
        if (result == null || result.isEmpty()) {
            return new Student();
        }
        int last = result.size() -1;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(result.get(last), Student.class);
    }

    public List<Student> getStudents() {
        String url = studentUrl + "/students";
        List<Student> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    public String readMessage(){
        String apiUrl = messagingUrl + "/receive";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public Student feignStudent() {
        String url = feignClientUrl + "/feign/students";
        System.out.println("\n\n\nFeignStudentURL : " + url);
        System.out.println("\n\n\n");
        List<Student> result = restTemplate.getForObject(url, List.class);
        if (result == null || result.isEmpty()) {
            return new Student();
        }
        int last = result.size() -1;
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(result.get(last), Student.class);
    }

    public Employee webEmployee() {
        String url = feignClientUrl + "/webClient/employees";
        System.out.println("\n\n\nWebEmployeeURL : " + url);
        System.out.println("\n\n\n");
        List<Employee> result = restTemplate.getForObject(url, List.class);
        if (result == null || result.isEmpty()) {
            return new Employee();
        }
        int last = result.size() -1;
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(result.get(last), Employee.class);
    }
}
