package com.employee.employee;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    @Hidden
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui-custom.html");
    }
}
