package com.example.demo.services.impls;

import com.example.demo.domains.Candidate;
import com.example.demo.domains.Employee;
import com.example.demo.domains.RecruitInterview;
import com.example.demo.dtos.recruits.RecruitInterviewCreateDTO;
import com.example.demo.dtos.recruits.RecruitInterviewDTO;
import com.example.demo.dtos.recruits.RecruitInterviewUpdateDTO;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.CandidateRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.RecruitInterviewRepository;
import com.example.demo.services.RecruitInterviewService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitInterviewServiceImpl implements RecruitInterviewService {

  private final RecruitInterviewRepository recruitInterviewRepository;
  private final EmployeeRepository employeeRepository;

  private final CandidateRepository candidateRepository;

  @Override
  public void create(RecruitInterviewCreateDTO request) {
    Employee employee = employeeRepository.findById(request.getEmployeeId());
    Candidate candidate = candidateRepository.findById(request.getCandidateId()).orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    RecruitInterview byCandidateId = recruitInterviewRepository.findByCandidateId(request.getCandidateId());
    if(byCandidateId != null){
      byCandidateId.setStatusDG(request.getStatusDG());
      byCandidateId.setNote(request.getNote());
      byCandidateId.setEmployeeId(request.getEmployeeId());
      return;
    }
    RecruitInterview recruitInterview = RecruitInterview.builder().statusDG(request.getStatusDG()).employeeId(employee.getId()).candidateId(candidate.getId()).note(request.getNote()).build();
    recruitInterviewRepository.save(recruitInterview);
  }

  @Override
  public void update(int id, RecruitInterviewUpdateDTO request) {
    RecruitInterview recruitInterview = recruitInterviewRepository.findById(id).orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));

    if (request.getExpertise() != null) {
      recruitInterview.setExpertise(request.getExpertise());
    }// Kiến thức chuyên môn
    if (request.getExperience() != null) {
      recruitInterview.setExperience(request.getExperience()); // Kinh nghiệm
    }
    if (request.getEnglishPoint() != null) {
      recruitInterview.setEnglishPoint(request.getEnglishPoint()); // Đánh giá trình độ tiếng anh
    }
    if (request.getAcquisitivenessPoint() != null) {
      recruitInterview.setAcquisitivenessPoint(request.getAcquisitivenessPoint()); // Đánh giá kĩ năng tiếp thu
    }
    if (request.getPresentationPoint() != null) {
      recruitInterview.setPresentationPoint(request.getPresentationPoint()); // Đánh giá kĩ năng  trình bày
    }
    if (request.getJudgmentPoint() != null) {
      recruitInterview.setJudgmentPoint(request.getJudgmentPoint()); // Đánh giá kĩ năng phán đoán
    }
    if (request.getCommunicationPoint() != null) {
      recruitInterview.setCommunicationPoint(request.getCommunicationPoint()); // Đánh giá kĩ năng giao tiếp
    }
    if (request.getManagementPoint() != null) {
      recruitInterview.setManagementPoint(request.getManagementPoint()); // Đánh giá kĩ năng quản lý
    }
    if (request.getLogicPoint() != null) {
      recruitInterview.setLogicPoint(request.getLogicPoint()); // Đánh giá tư duy logic
    }
    if (request.getPersonalityPoint() != null) {
      recruitInterview.setPersonalityPoint(request.getPersonalityPoint()); // Tính cách
    }
    if (request.getConfidentPoint() != null) {
      recruitInterview.setConfidentPoint(request.getConfidentPoint()); // Sự tự tin
    }
    if (request.getDressPoint() != null) {
      recruitInterview.setDressPoint(request.getDressPoint()); // Trang phục
    }
    if (request.getVoicePoint() != null) {
      recruitInterview.setVoicePoint(request.getVoicePoint()); // Giọng nói
    }
    if (request.getAttachmentPoint() != null) {
      recruitInterview.setAttachmentPoint(request.getAttachmentPoint()); // Sự gắn bó với cty
    }
    if (request.getWorkEnvironmentPoint() != null) {
      recruitInterview.setWorkEnvironmentPoint(request.getWorkEnvironmentPoint()); // Hiểu biết về môi trường làm việc
    }
    if (request.getPressurePotentialPoint() != null) {
      recruitInterview.setPressurePotentialPoint(request.getPressurePotentialPoint()); // Áp lực công việc
    }
    if (request.getOvertimePotentialPoint() != null) {
      recruitInterview.setOvertimePotentialPoint(request.getOvertimePotentialPoint()); // Sẵn sàng OT
    }
    if (request.getGeneralReview() != null) {
      recruitInterview.setGeneralReview(request.getGeneralReview()); // Đánh giá chung
    }
    if (request.getResult() != null) {
      recruitInterview.setResult(request.getResult()); // Kết quả
    }
    if (request.getSalaryExpect() != null) {
      recruitInterview.setSalaryExpect(request.getSalaryExpect()); // mức lương mong muốn
    }
    if (request.getNotePV() != null) {
      recruitInterview.setNotePV(request.getNotePV());
    }
    if (request.getNoteKQ() != null) {
      recruitInterview.setNoteKQ(request.getNoteKQ());
    }
    if (request.getNoteKL() != null) {
      recruitInterview.setNoteKL(request.getNoteKL());
    }
    if (request.getStatusKQ() != null) {
      recruitInterview.setStatusKQ(request.getStatusKQ());
    }
    if (request.getStatusPV() != null) {
      recruitInterview.setStatusPV(request.getStatusPV());
    }
    if (request.getStatusTGPV() != null) {
      recruitInterview.setStatusTGPV(request.getStatusTGPV());
    }
    if (request.getStatusKL() != null) {
      recruitInterview.setStatusKL(request.getStatusKL());
    }
    if (request.getTime() != null) {
      recruitInterview.setTime(request.getTime());
    }
    if (request.getType() != null) {
      recruitInterview.setType(request.getType());
    }
    if (request.getSalaryExpect() != null) {
      recruitInterview.setSalaryExpect(request.getSalaryExpect());
    }
    if (request.getTimeIncreaseSalary() != null) {
      recruitInterview.setTimeIncreaseSalary(request.getTimeIncreaseSalary());
    }
    if (request.getSalaryDeal() != null) {
      recruitInterview.setSalaryDeal(request.getSalaryDeal());
    }
    if (request.getAddress() != null) {
      recruitInterview.setAddress(request.getAddress());
    }
    recruitInterviewRepository.save(recruitInterview);
  }

  @Override
  public RecruitInterview get(int candidateId) {
    return recruitInterviewRepository.findByCandidateId(candidateId);
  }

  @Override
  public List<RecruitInterviewDTO> getAllByEmployeeId(int employeeId) {
    return null;
  }
}
