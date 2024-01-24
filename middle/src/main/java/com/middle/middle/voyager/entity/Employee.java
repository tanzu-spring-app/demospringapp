package com.middle.middle.voyager.entity;

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
}