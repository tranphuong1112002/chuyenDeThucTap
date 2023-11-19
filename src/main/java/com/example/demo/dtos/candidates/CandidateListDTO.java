package com.example.demo.dtos.candidates;

import com.example.demo.domains.Candidate;
import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.LevelCandidateEnum;
import com.example.demo.enums.StatusEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateListDTO {

  private int id;

  private String fullName;

  private String candidateCode;

  private String phone;

  private LevelCandidateEnum level;

  private int numberOfExp;

  private String email;

  private String careerGoals;


  private String note;


  private String hobbies;


  private String expectedSalary;

  private String applyPosition;
  private LocalDate birthDate;
  private String address;
  private GenderEnum gender;
  private StatusEnum status;

  public CandidateListDTO(Candidate candidate) {
    this.id = candidate.getId();
    this.fullName = candidate.getFullName();
    this.candidateCode = candidate.getCandidateCode();
    this.phone = candidate.getPhone();
    this.level = candidate.getLevel();
    this.numberOfExp = candidate.getNumberOfExp();
    this.email = candidate.getEmail();
    this.careerGoals = candidate.getCareerGoals();
    this.note = candidate.getNote();
    this.hobbies = candidate.getHobbies();
    this.expectedSalary = candidate.getExpectedSalary();
    this.applyPosition = candidate.getApplyPosition();
    this.birthDate = candidate.getBirthDate();
    this.address = candidate.getAddress();
    this.gender = candidate.getGender();
    this.status = candidate.getStatus();
  }
}
