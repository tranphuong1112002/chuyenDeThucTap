package com.example.demo.services;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import java.util.List;

public interface RecruitInterviewService {

  void create(RecruitInterview request);

  void update(int id, RecruitInterview request);

  RecruitInterviewDTO get(int id);

  List<RecruitInterviewDTO> getAllByEmployeeId(int employeeId);
}
