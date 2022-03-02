package com.mypractice.dynamodb.controller;

import com.mypractice.dynamodb.model.Employee;
import com.mypractice.dynamodb.serevice.EmployeeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Mono<Employee> saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/{employeeId}")
    public Mono<Employee> findById(@PathVariable String employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteById(@PathVariable String employeeId){
         employeeService.deleleteById(employeeId);
    }

    @PutMapping("/employee/{employeeId}")
    public Mono<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId){
        return employeeService.updateEmployee(employee, employeeId);
    }
}
