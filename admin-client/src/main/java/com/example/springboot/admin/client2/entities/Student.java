package com.example.springboot.admin.client2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "city")
    public String city;

    @Column(name = "standard")
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
