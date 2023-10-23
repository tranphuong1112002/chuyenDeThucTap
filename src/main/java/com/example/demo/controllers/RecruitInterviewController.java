package com.example.demo.controllers;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.services.RecruitInterviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruit-interview")
@RequiredArgsConstructor
public class RecruitInterviewController {

  private final RecruitInterviewService recruitInterviewService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody @Valid RecruitInterview request) {
    recruitInterviewService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable int id, @RequestBody @Valid RecruitInterview request) {
    recruitInterviewService.update(id, request);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable(name = "id") int id) {
    return ResponseEntity.status(HttpStatus.OK).body(recruitInterviewService.get(id));
  }

  @GetMapping("/employee/{employeeId}")
  public ResponseEntity<?> getAllByEmployeeId(@PathVariable(name = "employeeId") int employeeId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(recruitInterviewService.getAllByEmployeeId(employeeId));
  }
}
