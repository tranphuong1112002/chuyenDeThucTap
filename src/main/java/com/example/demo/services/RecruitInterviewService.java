package com.example.demo.services;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewCreateDTO;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import com.example.demo.dtos.recruits.RecruitInterviewUpdateDTO;

import java.util.List;

public interface RecruitInterviewService {

  void create(RecruitInterviewCreateDTO request);

  void update(int candidateId, RecruitInterviewUpdateDTO request);

  RecruitInterview get(int candidateId);

  List<RecruitInterviewDTO> getAllByEmployeeId(int employeeId);
}
