package com.middle.middle.voyager;

import com.middle.middle.voyager.entity.Employee;
import com.middle.middle.voyager.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MiddleService {

    @Value("${employee.service.host}")
    private String employeeServiceHost;
    @Value("${employee.service.port}")
    private String employeeServicePort;

    @Value("${student.service.host}")
    private String studentServiceHost;
    @Value("${student.service.port}")
    private String studentServicePort;

    @Value("${messaging.service.host}")
    private String messagingServiceHost;
    @Value("${messaging.service.port}")
    private String messagingServicePort;

    public List<Employee> getEmployees() {
        String url = "http://" + employeeServiceHost + ":" + employeeServicePort + "/employees";
        RestTemplate restTemplate = new RestTemplate();
        List<Employee> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    public List<Student> getStudents() {
        String url = "http://" + studentServiceHost + ":" + studentServicePort + "/students";
        RestTemplate restTemplate = new RestTemplate();
        List<Student> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    public void messageStudent() {
        RestTemplate restTemplate = new RestTemplate();
        String url1 = "http://" + studentServiceHost + ":" + studentServicePort + "/students";
        String message = restTemplate.getForObject(url1, String.class);

        String apiUrl = "http://" + messagingServiceHost + ":" + messagingServicePort + "/send";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(message, headers);

        restTemplate.postForObject(apiUrl, requestEntity, String.class);
    }

    public String readMessage() {
        String apiUrl = "http://" + messagingServiceHost + ":" + messagingServicePort + "/receive";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
