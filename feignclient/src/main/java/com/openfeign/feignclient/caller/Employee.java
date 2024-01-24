package com.openfeign.feignclient.caller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    public int id;
    public String firstName;
    public String lastName;
    public String city;
    public String designation;

    public Employee(final String firstName,
                    final String lastName,
                    final String city,
                    final String designation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.designation = designation;
    }
}

