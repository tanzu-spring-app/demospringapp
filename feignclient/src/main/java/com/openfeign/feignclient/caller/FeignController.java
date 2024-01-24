package com.openfeign.feignclient.caller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @Autowired
    private WebClientUtils webClientUtils;

    @GetMapping(path = "/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui-custom.html");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/feign/students")
    public List<Student> getAllStudents() {
        return feignServiceUtil.getStudents();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/webClient/employees")
    public List<Employee> getAllEmployees() {
        return webClientUtils.getEmployees();
    }
}
