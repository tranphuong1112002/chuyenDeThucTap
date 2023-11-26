package com.example.demo.domains;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
 
@Table(name = "recruit_interviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitInterview extends Audit{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "employee_id")
  private Integer employeeId;


  @Column(name = "candidate_id")
  private Integer candidateId;

  @Column(name = "status_dg", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum statusDG;

  @Column(name = "status_pv", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum statusPV;

  @Column(name = "status_tgpv", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum statusTGPV;

  @Column(name = "status_kq", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum statusKQ;

  @Column(name = "status_KL", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum statusKL;

  @Column(name = "interview_time")
  private LocalDateTime interviewTime;

  @Column(name = "note")
  private String note;

  @Column(name = "expertise")
  private String expertise; // Kiến thức chuyên môn

  @Column(name = "experience")
  private String experience; // Kinh nghiệm

  @Column(name = "english_point")
  private Integer englishPoint; // Đánh giá trình độ tiếng anh

  @Column(name = "acquisitiveness_point")
  private Integer acquisitivenessPoint; // Đánh giá kĩ năng tiếp thu

  @Column(name = "presentation_point")
  private Integer presentationPoint; // Đánh giá kĩ năng  trình bày

  @Column(name = "bargaining_point")
  private Integer bargainingPoint; // Đánh giá kĩ năng thương lượng

  @Column(name = "judgment_point")
  private Integer judgmentPoint; // Đánh giá kĩ năng phán đoán

  @Column(name = "communication_point")
  private Integer communicationPoint; // Đánh giá kĩ năng giao tiếp

  @Column(name = "management_point")
  private Integer managementPoint; // Đánh giá kĩ năng quản lý

  @Column(name = "logic_point")
  private Integer logicPoint; // Đánh giá tư duy logic

  @Column(name = "personality_point")
  private Integer personalityPoint; // Tính cách

  @Column(name = "confident_point")
  private Integer confidentPoint; // Sự tự tin

  @Column(name = "dress_point")
  private Integer dressPoint; // Trang phục

  @Column(name = "voice_point")
  private Integer voicePoint; // Giọng nói

  @Column(name = "attachment_point")
  private Integer attachmentPoint; // Sự gắn bó với cty

  @Column(name = "work_environment_point")
  private Integer workEnvironmentPoint; // Hiểu biết về môi trường làm việc

  @Column(name = "pressure_potential_point")
  private Integer pressurePotentialPoint; // Áp lực công việc

  @Column(name = "overtime_potential_point")
  private Integer overtimePotentialPoint; // Sẵn sàng OT

  @Column(name = "general_review")
  private String generalReview; // Đánh giá chung

  @Column(name = "result")
  private String result; // Kết quả

  @Column(name = "salaryExpect")
  private Double salaryExpect; // mức lương mong muốn

  @Column(name = "note_pv")
  private String notePV;

  @Column(name = "note_kq")
  private String noteKQ;

  @Column(name = "note_kl")
  private String noteKL;

  @Column(name = "time")
  private LocalDateTime time;

  @Column(name = "type")
  private String type;

  @Column(name = "time_increase_salary")
  private String timeIncreaseSalary;

  @Column(name = "salary_deal")
  private Double salaryDeal;

  @Column(name = "address")
  private String address;
}
