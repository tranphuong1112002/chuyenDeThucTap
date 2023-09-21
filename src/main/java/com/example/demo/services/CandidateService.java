package com.example.demo.services;

import com.example.demo.dtos.candidates.CandidateCreateDTO;
import com.example.demo.dtos.candidates.CandidateDetailDTO;

public interface CandidateService {

    // tạo mới ứng viên
    void createCandidate(CandidateCreateDTO dto);

    // update ứng viên
    void updateCandidate(int id, CandidateCreateDTO dto);

    // lấy chi tiết ứng viên
    CandidateDetailDTO getCandidate(int id);
}
