package com.example.demo.services;

import com.example.demo.domains.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployee(int id);
}
