package com.example.demo.services;

import com.example.demo.dtos.candidates.*;
import com.example.demo.enums.StatusEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateService {

  // tạo mới ứng viên
  void createCandidate(CandidateCreateDTO dto);

  // update ứng viên
  void updateCandidate(int id, CandidateCreateDTO dto);

  // lấy chi tiết ứng viên
  CandidateDetailDTO getCandidate(int id);

  // xoá ứng viên
  void deleteCandidate(int id);

  // tìm kiếm ứng viên
  Page<CandidateListDTO> findCandidates(CandidateSearchDTO dto, Pageable pageable);

  CandidateDashboardDTO getDashboard();

  Object export(HttpServletRequest request, StatusEnum status) throws Exception;
}
