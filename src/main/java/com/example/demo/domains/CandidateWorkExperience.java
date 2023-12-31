package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "candidate_work_experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateWorkExperience extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_work_experiences_generator")
  @SequenceGenerator(name = "candidate_work_experiences_generator", sequenceName = "candidate_work_experiences_seq", initialValue = 14, allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  @NotBlank(message = "Title không được bỏ trống")
  private String title;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "start_date")
  @NotNull(message = "Ngày bắt đầu không được bỏ trống")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "job_description", length = 1000)
  private String jobDescription;

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Candidate candidate;
}
