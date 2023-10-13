package com.example.demo.controllers;

import com.example.demo.domains.CandidateEducation;
import com.example.demo.domains.CandidateWorkExperience;
import com.example.demo.services.CandiateWorkExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
