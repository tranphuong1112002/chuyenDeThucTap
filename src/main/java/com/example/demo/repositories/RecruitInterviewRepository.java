package com.example.demo.repositories;

import com.example.demo.domains.RecruitInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecruitInterviewRepository extends JpaRepository<RecruitInterview, Integer> {

    @Query(value = "select r from RecruitInterview r where r.candidateId = :candidateId")
    RecruitInterview findByCandidateId(int candidateId);
}
