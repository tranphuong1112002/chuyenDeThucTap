package com.example.demo.repositories;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecruitInterviewRepository extends JpaRepository<RecruitInterview, Integer> {

    @Query("select new com.example.demo.dtos.recruits.RecruitInterviewDTO(r) from RecruitInterview r where r.employee.id = :employeeId")
    List<RecruitInterviewDTO> getRecruitInterviewList(int employeeId);
}
