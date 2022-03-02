package com.mypractice.dynamodb.serevice.impl;

import com.mypractice.dynamodb.model.Employee;
import com.mypractice.dynamodb.repository.GenericRepository;
import com.mypractice.dynamodb.serevice.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl(GenericRepository repository) {
        this.repository = repository;
    }

    public final GenericRepository repository;
    public Mono<Employee> saveEmployee(Employee employee){
      return Mono.fromSupplier(()->Optional.ofNullable( repository.save(employee))
              .map(o-> (Employee) o).orElseThrow(()->
                      new RuntimeException("Object cannot be empty")));
    }
}
