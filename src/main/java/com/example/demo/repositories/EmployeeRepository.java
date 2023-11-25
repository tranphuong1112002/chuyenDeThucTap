package com.example.demo.repositories;

import com.example.demo.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e from Employee e")
    List<Employee> findAll();

    @Query(value = "select e from Employee e where e.id = :id")
    Employee findById(int id);

    @Query(value = "select max(c.employeeIndex) from Employee c")
    Integer findMaxIndex();
}
