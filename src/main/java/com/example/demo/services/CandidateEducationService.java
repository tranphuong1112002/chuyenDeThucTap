package com.example.demo.services;

import com.example.demo.domains.CandidateEducation;

import java.util.List;

public interface CandidateEducationService {

    void create(CandidateEducation request);

    void update(int id, CandidateEducation request);

    void delete(int id);

    List<CandidateEducation> getAll(int candidateId);
}
