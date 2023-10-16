package com.example.demo.repositories;

import com.example.demo.domains.CandidateWorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateWorkExperienceRepository
    extends JpaRepository<CandidateWorkExperience, Integer> {

    @Query(value = "select c from CandidateWorkExperience c where c.candidate.id = :candidateId")
    List<CandidateWorkExperience> findAllByCandidateId(int candidateId);
}
