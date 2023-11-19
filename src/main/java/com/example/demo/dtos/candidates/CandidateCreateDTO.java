package com.example.demo.dtos.candidates;

import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.LevelCandidateEnum;
import com.example.demo.enums.StatusEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CandidateCreateDTO {

  @NotBlank(message = "Tên không được để trống")
  private String firstName;

  @NotBlank(message = "Họ không được để trống")
  private String lastName;

  @Pattern(
      regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
      message = "Số điện thoại không đúng định dạng")
  private String phone;

  @NotNull
  private LocalDate birthDate;

  private String address;

  private LevelCandidateEnum level;

  private GenderEnum gender;

  private Integer numberOfExp;

  @Email(message = "email không đúng định dạng")
  @NotBlank
  private String email;

  private String source;


  private String applyPosition;


  private String careerGoals;


  private String note;


  private String hobbies;


  private String expectedSalary;
  private StatusEnum status;
}
