package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "candidate_work_experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateWorkExperience extends Audit {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Candidate candidate;
}
