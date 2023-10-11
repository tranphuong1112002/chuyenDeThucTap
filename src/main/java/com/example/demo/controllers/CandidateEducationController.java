package com.example.demo.controllers;

import com.example.demo.domains.CandidateEducation;
import com.example.demo.services.CandidateEducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate-education")
@RequiredArgsConstructor
public class CandidateEducationController {

  private final CandidateEducationService candidateEducationService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody @Valid CandidateEducation request) {
    candidateEducationService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable(name = "id") int id, @RequestBody @Valid CandidateEducation request) {
    candidateEducationService.update(id, request);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
    candidateEducationService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/{candidate-id}")
  public ResponseEntity<?> getAll(@PathVariable(name = "candidate-id") int candidateId) {
    return ResponseEntity.status(HttpStatus.OK).body(candidateEducationService.getAll(candidateId));
  }
}
