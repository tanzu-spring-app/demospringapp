package com.openfeign.feignclient.caller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WebClientUtils {

    @Value("${spring.employee.url}")
    private String employeeUrl;

    @Autowired
    WebClient.Builder webClientBuilder;

    public List<Employee> getEmployees() {
        String employeeListUrl = employeeUrl + "/employees";
        ResponseEntity<List<Employee>> responseEntity = webClientBuilder.build()
                .get()
                .uri(employeeListUrl)
                .retrieve()
                .toEntityList(Employee.class)
                .block();
        assert responseEntity != null;
        return responseEntity.getBody();
    }
}
