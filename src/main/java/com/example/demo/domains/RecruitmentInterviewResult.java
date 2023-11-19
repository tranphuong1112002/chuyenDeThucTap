package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "recruit_interview_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentInterviewResult extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

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

  @OneToOne
  @JoinColumn(name = "recruit_interview_id")
  private RecruitInterview recruitInterview;
}