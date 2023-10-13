package com.example.demo.services;

import com.example.demo.domains.CandidateWorkExperience;
import java.util.List;

public interface CandiateWorkExperienceService {

  void create(CandidateWorkExperience request);

  void update(int id, CandidateWorkExperience request);

  void delete(int id);

  List<CandidateWorkExperience> getAll(int candiateId);
}
