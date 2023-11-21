package com.example.demo.repositories;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecruitInterviewRepository extends JpaRepository<RecruitInterview, Integer> {

    @Query(value = "select r from RecruitInterview r where r.candidate.id = :candidateId")
    RecruitInterview findByCandidateId(int candidateId);
}
