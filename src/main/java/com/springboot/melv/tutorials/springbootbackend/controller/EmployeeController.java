package com.springboot.melv.tutorials.springbootbackend.controller;

import com.springboot.melv.tutorials.springbootbackend.model.Employee;
import com.springboot.melv.tutorials.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create employee REST API

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.findEmployee(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findEmployees();
    }

    /* @GetMapping
    public List<Employee> getEmployees(@RequestParam("order-asc") int orderAsc) {
        return employeeService.findEmployees(orderAsc == 1);
    } */

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployeeById(
        @PathVariable("id") long id,
        @RequestBody Employee employee
    ) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
