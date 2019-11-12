package com.example.crud;
//package com.example.controller;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class EmployeeClient {

                       private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/employees";
                       private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/employees/{id}";
                       private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/employees";
                       private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/employees/{id}";
                       private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/employees/{id}";
                       private static RestTemplate restTemplate = new RestTemplate();

                       public static void main(String[] args) {
                                       EmployeeClient employeeClient = new EmployeeClient();

                                       employeeClient.createEmployee();
                                       employeeClient.getEmployeeById();
                                       //bookClient.getBookById();
                                       employeeClient.updateEmployee();
                                       employeeClient.deleteEmployee();
                       }

                       private void getEmployees() {

                                       HttpHeaders headers = new HttpHeaders();
                                       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                                       HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

                                       ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
                                                                       String.class);

                                       System.out.println(result);
                       }

                       private void getEmployeeById() {

                                       Map<String, String> params = new HashMap<String, String>();
                                       params.put("id", "1");

                                       RestTemplate restTemplate = new RestTemplate();
                                       Employee result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, params);

                                       System.out.println(result);
                       }

                       private void createEmployee() {

                                       Employee newEmployee = new Employee();

                                       RestTemplate restTemplate = new RestTemplate();
                                      Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);

                                       System.out.println(result);
                       }

                       private void updateEmployee() {
                                       Map<String, String> params = new HashMap<String, String>();
                                       params.put("id", "1");
                                       Book updatedBook = new Book();
                                       RestTemplate restTemplate = new RestTemplate();
                                       restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedBook, params);
                       }

                       private void deleteEmployee() {
                                       Map<String, String> params = new HashMap<String, String>();
                                       params.put("id", "1");
                                       RestTemplate restTemplate = new RestTemplate();
                                       restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
                       }
       } 





