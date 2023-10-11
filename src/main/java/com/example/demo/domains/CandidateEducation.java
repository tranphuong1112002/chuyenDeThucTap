package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "candidate_educations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateEducation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "edu_name")
    @NotBlank(message = "Tên trường học không được để trống")
    private String eduName;

    @Column(name = "majors")
    @NotBlank(message = "Tên ngành học không được để trống")
    private String majors;

    @Column(name = "form_of_training")
    @NotBlank(message = "Hình thức đào tạo không được để trống")
    private String formOfTraining;

    @Column(name = "certification")
    private String certification;

    @Column(name = "start_date")
    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @JsonIgnore
    private Candidate candidate;
}
