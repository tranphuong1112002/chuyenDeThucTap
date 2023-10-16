package com.example.demo.controllers;

import com.example.demo.domains.CandidateWorkExperience;
import com.example.demo.services.CandiateWorkExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate-work-experience")
@RequiredArgsConstructor
public class CandidateWorkExperienceController {

  private final CandiateWorkExperienceService candiateWorkExperienceService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody @Valid CandidateWorkExperience request) {
    candiateWorkExperienceService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable int id, @RequestBody @Valid CandidateWorkExperience request) {
    candiateWorkExperienceService.update(id, request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
    candiateWorkExperienceService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/{candidate-id}")
  public ResponseEntity<?> getAll(@PathVariable(name = "candidate-id") int candidateId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(candiateWorkExperienceService.getAll(candidateId));
  }
}
