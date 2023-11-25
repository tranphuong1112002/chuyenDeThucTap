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
public class RecruitInterviewUpdateDTO {


  private StatusEnum statusPV;

  private StatusEnum statusTGPV;

  private StatusEnum statusKQ;

  private StatusEnum statusKL;

  private String expertise; // Kiến thức chuyên môn

  private String experience; // Kinh nghiệm

  private Integer englishPoint; // Đánh giá trình độ tiếng anh

  private Integer acquisitivenessPoint; // Đánh giá kĩ năng tiếp thu

  private Integer presentationPoint; // Đánh giá kĩ năng  trình bày

  private Integer bargainingPoint; // Đánh giá kĩ năng thương lượng

  private Integer judgmentPoint; // Đánh giá kĩ năng phán đoán

  private Integer communicationPoint; // Đánh giá kĩ năng giao tiếp

  private Integer managementPoint; // Đánh giá kĩ năng quản lý

  private Integer logicPoint; // Đánh giá tư duy logic

  private Integer personalityPoint; // Tính cách

  private Integer confidentPoint; // Sự tự tin

  private Integer dressPoint; // Trang phục

  private Integer voicePoint; // Giọng nói

  private Integer attachmentPoint; // Sự gắn bó với cty

  private Integer workEnvironmentPoint; // Hiểu biết về môi trường làm việc

  private Integer pressurePotentialPoint; // Áp lực công việc

  private Integer overtimePotentialPoint; // Sẵn sàng OT

  private String generalReview; // Đánh giá chung

  private String result; // Kết quả

  private Double salaryExpect; // mức lương mong muốn

  private String notePV;

  private String noteKQ;

  private String noteKL;

  private String type;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime time;

  private String timeIncreaseSalary;

  private Double salaryDeal;
}
