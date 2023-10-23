package com.example.demo.services.impls;

import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.RecruitInterviewRepository;
import com.example.demo.services.RecruitInterviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitInterviewServiceImpl implements RecruitInterviewService {

  private final RecruitInterviewRepository recruitInterviewRepository;

  @Override
  public void create(RecruitInterview request) {
    recruitInterviewRepository.save(
        RecruitInterview.builder()
            .interviewTime(request.getInterviewTime())
            .note(request.getNote())
            .candidate(request.getCandidate())
            .employee(request.getEmployee())
            .status(request.getStatus())
            .build());
  }

  @Override
  public void update(int id, RecruitInterview request) {
    RecruitInterview recruitInterview =
        recruitInterviewRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    recruitInterview.setInterviewTime(request.getInterviewTime());
    recruitInterview.setStatus(request.getStatus());
    recruitInterview.setEmployee(request.getEmployee());
    recruitInterview.setNote(request.getNote());
    recruitInterviewRepository.save(recruitInterview);
  }

  @Override
  public RecruitInterviewDTO get(int id) {
    RecruitInterview recruitInterview = recruitInterviewRepository.findById(id).orElse(null);
    if (recruitInterview == null) {
      return null;
    }
    return new RecruitInterviewDTO(recruitInterview);
  }

  @Override
  public List<RecruitInterviewDTO> getAllByEmployeeId(int employeeId) {
    return recruitInterviewRepository.getRecruitInterviewList(employeeId);
  }
}
