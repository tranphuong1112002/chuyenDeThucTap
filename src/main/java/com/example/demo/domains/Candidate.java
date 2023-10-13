package com.example.demo.domains;

import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.LevelCandidateEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.List;

@Entity
@Audited
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "candidate_code", length = 50)
    private String candidateCode;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "level_code", length = 20)
    @Enumerated(EnumType.STRING)
    private LevelCandidateEnum level; // Mã level (senior, middle, junior,..)

    @Column(name = "gender_code", length = 20)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Getter
    @Column(name = "number_of_exp")
    private int numberOfExp; // số năm kinh nghiệm

    @NotAudited
    @Column(name = "candidate_index")
    private Integer candidateIndex;

    @Column(name = "full_name_unsighted", length = 200)
    private String fullNameUnsighted;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "source", length = 50)
    private String source; // nguồn ứng viên

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CandidateEducation> educations;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CandidateWorkExperience> candidateWorkExperiences;

    public String getFullName() {
        return this.lastName + " " + this.firstName;
    }
}
