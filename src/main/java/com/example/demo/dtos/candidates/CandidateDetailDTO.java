package com.example.demo.dtos.candidates;

import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.LevelCandidateEnum;
import lombok.*;

import java.time.LocalDate;

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
}
