package com.mypractice.dynamodb.controller;

import com.mypractice.dynamodb.model.Employee;
import com.mypractice.dynamodb.serevice.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
