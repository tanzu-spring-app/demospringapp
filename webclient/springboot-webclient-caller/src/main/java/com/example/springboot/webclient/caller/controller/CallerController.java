package com.example.springboot.webclient.caller.controller;

import com.example.springboot.webclient.caller.Callee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/caller")
public class CallerController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    private Callee callee;

    @GetMapping
    public String getRandomNumber() {
        Integer randomNumber = webClientBuilder.build()
                .get()
                .uri(callee.getUrl())
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        return "Random number : " + randomNumber;
    }
}
