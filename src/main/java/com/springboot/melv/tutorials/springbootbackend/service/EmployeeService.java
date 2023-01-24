package com.springboot.melv.tutorials.springbootbackend.service;

import com.springboot.melv.tutorials.springbootbackend.exception.ResourceNotFoundException;
import com.springboot.melv.tutorials.springbootbackend.model.Employee;
import com.springboot.melv.tutorials.springbootbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findEmployeeById(long id) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return employee.get();
        throw new ResourceNotFoundException("Employee", "id", id);
    }

    public List<Employee> findEmployees() {
        return this.employeeRepository.findAll();
    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, long id) {
        Employee employeeInDb = findEmployeeById(id);
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String email = employee.getEmail();

        if (firstName != null)
            employeeInDb.setFirstName(firstName);
        if (lastName != null)
            employeeInDb.setLastName(lastName);
        if (email != null)
            employeeInDb.setEmail(email);

        return employeeRepository.save(employeeInDb);
    }
}
