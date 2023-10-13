package com.example.demo.controllers;

import com.example.demo.domains.CandidateWorkExperience;
import com.example.demo.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<?> getAllEmployee() {
    return ResponseEntity.ok(employeeService.getAllEmployee());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployee(@PathVariable int id) {
    return ResponseEntity.ok(employeeService.getEmployee(id));
  }
}
