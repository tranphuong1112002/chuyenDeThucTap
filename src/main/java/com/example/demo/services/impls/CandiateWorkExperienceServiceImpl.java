package com.example.demo.services.impls;

import com.example.demo.domains.CandidateWorkExperience;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.CandidateWorkExperienceRepository;
import com.example.demo.services.CandiateWorkExperienceService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandiateWorkExperienceServiceImpl implements CandiateWorkExperienceService {

  private final CandidateWorkExperienceRepository candidateWorkExperienceRepository;

  @Override
  public void create(CandidateWorkExperience request) {
    CandidateWorkExperience candidateWorkExperience =
        CandidateWorkExperience.builder()
            .title(request.getTitle())
            .companyName(request.getCompanyName())
            .startDate(request.getStartDate())
            .endDate(request.getEndDate())
            .jobDescription(request.getJobDescription())
            .candidate(request.getCandidate())
            .build();
    candidateWorkExperienceRepository.save(candidateWorkExperience);
  }

  @Override
  public void update(int id, CandidateWorkExperience request) {
    CandidateWorkExperience candidateWorkExperience =
        candidateWorkExperienceRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    candidateWorkExperience.setTitle(request.getTitle());
    candidateWorkExperience.setCompanyName(request.getCompanyName());
    candidateWorkExperience.setStartDate(request.getStartDate());
    candidateWorkExperience.setEndDate(request.getEndDate());
    candidateWorkExperience.setJobDescription(request.getJobDescription());
    candidateWorkExperienceRepository.save(candidateWorkExperience);
  }

  @Override
  public void delete(int id) {
    candidateWorkExperienceRepository
        .findById(id)
        .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    candidateWorkExperienceRepository.deleteById(id);
  }

  @Override
  public List<CandidateWorkExperience> getAll(int candiateId) {
    return candidateWorkExperienceRepository.findAllByCandidateId(candiateId);
  }
}
