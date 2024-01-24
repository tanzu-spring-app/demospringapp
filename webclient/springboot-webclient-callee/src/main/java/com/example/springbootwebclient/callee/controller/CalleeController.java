package com.example.springbootwebclient.callee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/callee")
public class CalleeController {
    @GetMapping("/random")
    public Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
