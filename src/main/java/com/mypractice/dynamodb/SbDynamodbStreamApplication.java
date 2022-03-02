package com.mypractice.dynamodb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.dynamodb.model.Address;
import com.mypractice.dynamodb.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class SbDynamodbStreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbDynamodbStreamApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Employee emp = new Employee();
		emp.setAddress(new Address());
		System.out.println(new ObjectMapper().writeValueAsString(emp));
	};
}
