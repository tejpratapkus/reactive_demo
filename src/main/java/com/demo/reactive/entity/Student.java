package com.demo.reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private int age;

}
