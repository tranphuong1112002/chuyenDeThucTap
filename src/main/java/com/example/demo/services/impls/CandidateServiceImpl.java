package com.example.demo.services.impls;

import com.example.demo.domains.Candidate;
import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.dtos.candidates.CandidateDetailDTO;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.CandidateRepository;
import com.example.demo.services.CandidateService;
import com.example.demo.utils.Utils;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

  private final CandidateRepository candidateRepository;

  @Override
  public void createCandidate(CandidateCreateDTO dto) {
    Integer maxIndex = candidateRepository.findMaxIndex();
    if (maxIndex == null) {
      maxIndex = 0;
    }
    int newIndex = maxIndex + 1;
    String candidateCode = "UV" + String.format("%05d", newIndex);
    Candidate newCandidate =
        Candidate.builder()
            .firstName(dto.getFirstName())
            .lastName(dto.getLastName())
            .candidateCode(candidateCode)
            .phone(dto.getPhone())
            .birthDate(dto.getBirthDate())
            .address(dto.getAddress())
            .level(dto.getLevel())
            .gender(dto.getGender())
            .numberOfExp(dto.getNumberOfExp())
            .candidateIndex(newIndex)
            .fullNameUnsighted(Utils.getFullNameUnsighted(dto.getLastName(), dto.getFirstName()))
            .build();
    candidateRepository.save(newCandidate);
  }

  @Override
  public void updateCandidate(int id, CandidateCreateDTO dto) {
    Candidate candidate =
        candidateRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    Optional.ofNullable(dto.getFirstName()).ifPresent(candidate::setFirstName);
    Optional.ofNullable(dto.getLastName()).ifPresent(candidate::setLastName);
    Optional.ofNullable(dto.getPhone()).ifPresent(candidate::setPhone);
    Optional.ofNullable(dto.getBirthDate()).ifPresent(candidate::setBirthDate);
    Optional.ofNullable(dto.getAddress()).ifPresent(candidate::setAddress);
    Optional.ofNullable(dto.getLevel()).ifPresent(candidate::setLevel);
    Optional.ofNullable(dto.getGender()).ifPresent(candidate::setGender);
    Optional.ofNullable(dto.getNumberOfExp()).ifPresent(candidate::setNumberOfExp);
    candidateRepository.save(candidate);
  }

  @Override
  public CandidateDetailDTO getCandidate(int id) {
    Candidate candidate =
        candidateRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    String genderName = candidate.getGender().getName();

    return null;
  }
}
