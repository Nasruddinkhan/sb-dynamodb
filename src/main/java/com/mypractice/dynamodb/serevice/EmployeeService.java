package com.mypractice.dynamodb.serevice;

import com.mypractice.dynamodb.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> saveEmployee(Employee employee);

    Mono<Employee> getEmployee(String employeeId);

    void deleleteById(String employeeId);

    Mono<Employee> updateEmployee(Employee employee, String employeeId);
}
