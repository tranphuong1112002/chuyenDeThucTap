package com.example.demo.repositories;

import com.example.demo.domains.CandidateEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEducationRepository extends JpaRepository<CandidateEducation, Integer> {
}
