package com.springboot.melv.tutorials.springbootbackend.repository;

import com.springboot.melv.tutorials.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
