package com.example.demo.dtos.candidates;

import com.example.demo.domains.Candidate;
import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.LevelCandidateEnum;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDetailDTO {

  private int id;

  private String firstName;

  private String lastName;

  private String candidateCode;

  private String phone;

  private LocalDate birthDate;

  private String address;

  private LevelCandidateEnum level;

  private GenderEnum gender;

  private String genderName;

  private int numberOfExp;

  private String fullName;

  private String email;

  private String source;

  public CandidateDetailDTO(Candidate candidate) {
    this.id = candidate.getId();
    this.firstName = candidate.getFirstName();
    this.lastName = candidate.getLastName();
    this.candidateCode = candidate.getCandidateCode();
    this.phone = candidate.getPhone();
    this.birthDate = candidate.getBirthDate();
    this.address = candidate.getAddress();
    this.level = candidate.getLevel();
    this.gender = candidate.getGender();
    this.genderName = candidate.getGender().getName();
    this.numberOfExp = candidate.getNumberOfExp();
    this.fullName = candidate.getFullName();
    this.email = candidate.getEmail();
    this.source = candidate.getSource();
  }
}
