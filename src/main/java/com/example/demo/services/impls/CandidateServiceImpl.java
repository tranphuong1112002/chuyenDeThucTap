package com.example.demo.services.impls;

import com.example.demo.domains.Candidate;
import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.dtos.candidates.CandidateDetailDTO;
import com.example.demo.dtos.candidates.CandidateListDTO;
import com.example.demo.dtos.candidates.CandidateSearchDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.CandidateRepository;
import com.example.demo.services.CandidateService;
import com.example.demo.services.UserService;
import com.example.demo.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final CandidateRepository candidateRepository;
    private final UserService userService;

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
                        .email(dto.getEmail())
                        .source(dto.getSource())
                        .careerGoals(dto.getCareerGoals())
                        .applyPosition(dto.getApplyPosition())
                        .note(dto.getNote())
                        .expectedSalary(dto.getExpectedSalary())
                        .applyPosition(dto.getApplyPosition())
                        .status(StatusEnum.CHO_DANH_GIA)
                        .hobbies(dto.getHobbies())
                        .build();
        Candidate candidate = candidateRepository.saveAndFlush(newCandidate);
        int candidateId = candidate.getId();
        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                .username(dto.getEmail())
                .password(dto.getPhone())
                .candidateId(candidateId)
                .build();
        userService.signUp(userRequestDTO);
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
        Optional.ofNullable(dto.getEmail()).ifPresent(candidate::setEmail);
        Optional.ofNullable(dto.getSource()).ifPresent(candidate::setSource);
        Optional.ofNullable(dto.getCareerGoals()).ifPresent(candidate::setCareerGoals);
        Optional.ofNullable(dto.getNote()).ifPresent(candidate::setNote);
        Optional.ofNullable(dto.getHobbies()).ifPresent(candidate::setHobbies);
        Optional.ofNullable(dto.getExpectedSalary()).ifPresent(candidate::setExpectedSalary);
        Optional.ofNullable(dto.getApplyPosition()).ifPresent(candidate::setApplyPosition);
        Optional.ofNullable(dto.getStatus()).ifPresent(candidate::setStatus);
        candidateRepository.save(candidate);
    }

    @Override
    public CandidateDetailDTO getCandidate(int id) {
        Candidate candidate =
                candidateRepository
                        .findById(id)
                        .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
        return new CandidateDetailDTO(candidate);
    }

    @Override
    public void deleteCandidate(int id) {
        Candidate candidate =
                candidateRepository
                        .findById(id)
                        .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
        candidateRepository.delete(candidate);
    }

    @Override
    public Page<CandidateListDTO> findCandidates(CandidateSearchDTO dto, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Candidate> cq = cb.createQuery(Candidate.class);
        Root<Candidate> root = cq.from(Candidate.class);
        List<Predicate> predicates = new ArrayList<>();
        var currentUser = userService.getUserInfo();
        if (currentUser.getCandidateId() != null) {
            return new PageImpl<>(candidateRepository.findById(currentUser.getCandidateId()).map(CandidateListDTO::new).stream().toList(), pageable, 1);
        }
        if (StringUtils.isNotBlank(dto.getFullName())) {
            predicates.add(
                    cb.like(
                            cb.lower(root.get("fullNameUnsighted")),
                            '%' + Utils.convertToString(dto.getFullName().trim().toLowerCase()) + '%'));
        }
        if (StringUtils.isNotBlank(dto.getEmail())) {
            predicates.add(
                    cb.like(cb.lower(root.get("email")), '%' + dto.getEmail().trim().toLowerCase() + '%'));
        }
        if (StringUtils.isNotBlank(dto.getSource())) {
            predicates.add(
                    cb.like(cb.lower(root.get("source")), '%' + dto.getSource().trim().toLowerCase() + '%'));
        }
        if (dto.getLevel() != null) {
            predicates.add(cb.equal(root.get("level"), dto.getLevel()));
        }
        if (StringUtils.isNotBlank(dto.getPhone())) {
            predicates.add(cb.equal(root.get("phone"), dto.getPhone()));
        }
        if (dto.getNumberOfExp() != null) {
            predicates.add(cb.equal(root.get("numberOfExp"), dto.getNumberOfExp()));
        }
        if (StringUtils.isNotBlank(dto.getCandidateCode())) {
            predicates.add(cb.equal(root.get("candidateCode"), dto.getCandidateCode()));
        }
        if (dto.getStatus() != null) {
            predicates.add(cb.equal(root.get("status"), dto.getStatus()));
        }
        cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
        TypedQuery<Candidate> candidateTypedQuery = entityManager.createQuery(cq);
        candidateTypedQuery.setFirstResult((int) pageable.getOffset());
        candidateTypedQuery.setMaxResults(pageable.getPageSize());
        List<Candidate> candidates = candidateTypedQuery.getResultList();

        List<CandidateListDTO> candidateListDTOs =
                candidates.stream().map(CandidateListDTO::new).toList();

        CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
        countCq.select(cb.count(countCq.from(Candidate.class)));
        Long count = entityManager.createQuery(countCq).getSingleResult();

        return new PageImpl<>(candidateListDTOs, pageable, count);
    }
}
