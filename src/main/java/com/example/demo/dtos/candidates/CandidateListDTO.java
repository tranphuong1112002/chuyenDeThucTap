package com.example.demo.dtos.candidates;

import com.example.demo.domains.Candidate;
import com.example.demo.enums.LevelCandidateEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateListDTO {

  private String fullName;

  private String candidateCode;

  private String phone;

  private LevelCandidateEnum level;

  private int numberOfExp;

  private String email;

  public CandidateListDTO(Candidate candidate) {
    this.fullName = candidate.getFullName();
    this.candidateCode = candidate.getCandidateCode();
    this.phone = candidate.getPhone();
    this.level = candidate.getLevel();
    this.numberOfExp = candidate.getNumberOfExp();
    this.email = candidate.getEmail();
  }
}
