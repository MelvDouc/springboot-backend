package com.springboot.melv.tutorials.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name", length=50, nullable=false)
    private String firstName;
    @Column(name="last_name", length=50, nullable=false)
    private String lastName;
    @Column(name="email", length=100, nullable=false)
    private String email;
}
