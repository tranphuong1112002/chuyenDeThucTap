package com.example.demo.services;

import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.dtos.candidates.CandidateDetailDTO;
import com.example.demo.dtos.candidates.CandidateListDTO;
import com.example.demo.dtos.candidates.CandidateSearchDTO;
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
}
