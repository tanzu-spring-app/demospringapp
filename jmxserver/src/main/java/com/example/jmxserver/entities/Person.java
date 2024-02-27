package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="person")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Long id;

    private String name;

    private Integer numberOfCards;

}
