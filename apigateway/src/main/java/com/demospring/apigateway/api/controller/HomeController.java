package com.demospring.apigateway.api.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui-custom.html");
    }
}
