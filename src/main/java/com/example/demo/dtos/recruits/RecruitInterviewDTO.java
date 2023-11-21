package com.example.demo.dtos.recruits;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitInterviewDTO {

  private int id;

  private StatusEnum status;

  private String statusName;

  private LocalDateTime interviewTime;

  private String note;

//  public RecruitInterviewDTO(RecruitInterview recruitInterview) {
//    this.id = recruitInterview.getId();
//    this.status = recruitInterview.getStatus();
//    this.statusName = recruitInterview.getStatus().getName();
//    this.interviewTime = recruitInterview.getInterviewTime();
//    this.note = recruitInterview.getNote();
//  }
}
