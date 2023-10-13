package com.example.demo.services.impls;

import com.example.demo.domains.CandidateWorkExperience;
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
            .candidate(request.getCandidate())
            .build();
    candidateWorkExperienceRepository.save(candidateWorkExperience);
  }

  @Override
  public void update(int id, CandidateWorkExperience request) {}

  @Override
  public void delete(int id) {}

  @Override
  public List<CandidateWorkExperience> getAll(int candiateId) {
    return null;
  }
}
