package com.example.demo.dtos.recruits;

import com.example.demo.enums.StatusEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitInterviewCreateDTO {

  private int employeeId;

  private int candidateId;

  private StatusEnum statusDG;

  private String note;
}
