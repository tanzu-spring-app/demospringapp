package com.demospring.apigateway.api.controller;

import com.demospring.apigateway.api.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/rabbitmq")
public class MessagingController {

    @Autowired
    private GatewayService gatewayService;

    @GetMapping(path = "/read/message")
    public String readMessage() {
        return gatewayService.readMessage();
    }
}
