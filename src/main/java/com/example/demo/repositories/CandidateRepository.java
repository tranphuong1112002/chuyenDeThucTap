package com.example.demo.repositories;

import com.example.demo.domains.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query(value = "select max(c.candidateIndex) from Candidate c")
    Integer findMaxIndex();
}
