package com.demospring.apigateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public int id;
    public String firstName;
    public String lastName;
    public String city;
    public int standard;
}