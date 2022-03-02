package com.mypractice.dynamodb.serevice;

import com.mypractice.dynamodb.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> saveEmployee(Employee employee);
}
