package com.openfeign.feignclient.caller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="ratingService", url="${spring.student.url}")
public interface FeignServiceUtil {

    @RequestMapping(method = RequestMethod.GET, value = "/students")
    List<Student> getStudents();
}
