package com.openfeign.feignclient.caller;

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

    public Student(final String firstName,
                   final String lastName,
                   final String city,
                   final int standard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.standard = standard;
    }
}

