package com.demospring.apigateway.api.controller;

import com.demospring.apigateway.api.service.GatewayService;
import com.demospring.apigateway.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/student")
public class StudentController {

    @Autowired
    private GatewayService gatewayService;

    @RequestMapping(method = RequestMethod.GET, path = "/lastStudent")
    public Student readLastStudent() {
        return gatewayService.getStudent();
    }
}
