package com.example.demo.dtos.candidates;

import com.example.demo.enums.LevelCandidateEnum;
import com.example.demo.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateSearchDTO {

  private String fullName;

  private String email;

  private String phone;

  // bo sung ki nang

  private LevelCandidateEnum level;

  private Integer numberOfExp;

  private String source;

  private String candidateCode;

  private StatusEnum status;
}
