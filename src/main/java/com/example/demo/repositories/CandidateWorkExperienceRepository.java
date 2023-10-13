package com.example.demo.repositories;

import com.example.demo.domains.CandidateWorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateWorkExperienceRepository
    extends JpaRepository<CandidateWorkExperience, Integer> {}
