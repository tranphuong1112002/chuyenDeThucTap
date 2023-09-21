package com.example.demo.controllers;

import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {

  private final CandidateService candidateService;

  @PostMapping
  public ResponseEntity<?> createCandidate(@RequestBody @Valid CandidateCreateDTO dto) {
    candidateService.createCandidate(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> createCandidate(
      @PathVariable(name = "id") int id, @RequestBody @Valid CandidateCreateDTO dto) {
    candidateService.updateCandidate(id, dto);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }
}
