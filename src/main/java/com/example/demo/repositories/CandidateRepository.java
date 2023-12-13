package com.example.demo.repositories;

import com.example.demo.domains.Candidate;
import com.example.demo.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

  @Query(value = "select max(c.candidateIndex) from Candidate c")
  Integer findMaxIndex();

  @Query(value = "select count(c.id) from Candidate c")
  int countAll();

  @Query(value = "select count(r.id) from Candidate c join RecruitInterview r on c.id = r.candidateId " +
      "where r.statusDG = :statusEnum ")
  int countAllByStatusDG(StatusEnum statusEnum);

  @Query(value = "select count(r.id) from Candidate c join RecruitInterview r on c.id = r.candidateId " +
      "where r.statusKL = :statusEnum ")
  int countAllByStatusPV(StatusEnum statusEnum);

  List<Candidate> findAllByStatusIs(StatusEnum status);
}
