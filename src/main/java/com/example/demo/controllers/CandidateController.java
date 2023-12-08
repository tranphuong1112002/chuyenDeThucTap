package com.example.demo.controllers;

import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.dtos.candidates.CandidateDashboardDTO;
import com.example.demo.dtos.candidates.CandidateSearchDTO;
import com.example.demo.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
public class CandidateController {

  private final CandidateService candidateService;

  @PostMapping
  public ResponseEntity<?> createCandidate(@RequestBody @Valid CandidateCreateDTO dto) {
    candidateService.createCandidate(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateCandidate(
      @PathVariable(name = "id") int id, @RequestBody @Valid CandidateCreateDTO dto) {
    candidateService.updateCandidate(id, dto);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCandidate(@PathVariable(name = "id") int id) {
    return ResponseEntity.status(HttpStatus.OK).body(candidateService.getCandidate(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCandidate(@PathVariable(name = "id") int id) {
    candidateService.deleteCandidate(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping
  public ResponseEntity<?> getCandidate(CandidateSearchDTO dto, Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(candidateService.findCandidates(dto, pageable));
  }

  @GetMapping("/dashboard")
  public ResponseEntity<?> getDashboard() {
    return ResponseEntity.status(HttpStatus.OK).body(candidateService.getDashboard());
  }
}
