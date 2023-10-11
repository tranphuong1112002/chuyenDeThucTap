package com.example.demo.services.impls;

import com.example.demo.domains.Candidate;
import com.example.demo.domains.CandidateEducation;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.CandidateEducationRepository;
import com.example.demo.repositories.CandidateRepository;
import com.example.demo.services.CandidateEducationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateEducationServiceImpl implements CandidateEducationService {

  private final CandidateEducationRepository candidateEducationRepository;
  private final CandidateRepository candidateRepository;

  @Override
  public void create(CandidateEducation request) {
    candidateEducationRepository.save(
        CandidateEducation.builder()
            .eduName(request.getEduName())
            .majors(request.getMajors())
            .certification(request.getCertification())
            .formOfTraining(request.getFormOfTraining())
            .startDate(request.getStartDate())
            .endDate(request.getEndDate())
            .candidate(request.getCandidate())
            .build());
  }

  @Override
  public void update(int id, CandidateEducation request) {
    CandidateEducation candidateEducation =
        candidateEducationRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));

    candidateEducation.setCertification(request.getCertification());
    candidateEducation.setMajors(request.getMajors());
    candidateEducation.setEduName(request.getEduName());
    candidateEducation.setStartDate(request.getStartDate());
    candidateEducation.setEndDate(request.getEndDate());
    candidateEducation.setFormOfTraining(request.getFormOfTraining());
    candidateEducationRepository.save(candidateEducation);
  }

  @Override
  public void delete(int id) {
    if (candidateEducationRepository.existsById(id)) {
      candidateEducationRepository.deleteById(id);
    }
  }

  @Override
  public List<CandidateEducation> getAll(int candidateId) {
    Candidate candidate =
        candidateRepository
            .findById(candidateId)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    return candidate.getEducations();
  }
}
