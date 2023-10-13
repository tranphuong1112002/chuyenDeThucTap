package com.example.demo.domains;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Entity
@Audited
@Table(name = "employees")
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

  @Column(name = "candidate_code")
  private String candidateCode; // Mã ứng viên

  @Column(name = "employee_code")
  private String employeeCode; // Mã nhân viên

  @OneToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @OneToOne
  @JoinColumn(name = "candidate_id")
  private Candidate candidate;

  @Column(name = "status", length = 20)
  @Enumerated(EnumType.STRING)
  private StatusEnum status;

  @Column(name = "interview_time")
  private LocalDateTime interviewTime;

  @Column(name = "note")
  private String note; // ví dụ pv online thì phải có link gg meet, pv offline thì ghi địa chỉ
}
