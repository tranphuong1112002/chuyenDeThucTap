package com.example.demo.domains;

import com.example.demo.enums.StatusEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
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

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @OneToOne(fetch = FetchType.LAZY)
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
