package com.example.demo.controllers;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewCreateDTO;
import com.example.demo.dtos.recruits.RecruitInterviewUpdateDTO;
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
  public ResponseEntity<?> create(@RequestBody @Valid RecruitInterviewCreateDTO request) {
    recruitInterviewService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable int id, @RequestBody @Valid RecruitInterviewUpdateDTO request) {
    recruitInterviewService.update(id, request);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @GetMapping("/{candidateId}")
  public ResponseEntity<?> get(@PathVariable int candidateId) {
    return ResponseEntity.status(HttpStatus.OK).body(recruitInterviewService.get(candidateId));
  }

  @GetMapping("/employee/{employeeId}")
  public ResponseEntity<?> getAllByEmployeeId(@PathVariable(name = "employeeId") int employeeId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(recruitInterviewService.getAllByEmployeeId(employeeId));
  }
}
