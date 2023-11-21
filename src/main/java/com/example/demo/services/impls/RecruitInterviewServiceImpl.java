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
    RecruitInterview recruitInterview = RecruitInterview.builder()
        .statusDG(request.getStatusDG())
        .employee(employee)
        .candidate(candidate)
        .note(request.getNote())
        .build();
    recruitInterviewRepository.save(recruitInterview);
  }

  @Override
  public void update(int id, RecruitInterviewUpdateDTO request) {
    RecruitInterview recruitInterview =
        recruitInterviewRepository
            .findById(id)
            .orElseThrow(() -> new RCException(ExceptionUtils.E_RECORD_NOT_EXIST));
    recruitInterview.setExpertise(request.getExpertise()); // Kiến thức chuyên môn
    recruitInterview.setExperience(request.getExperience()); // Kinh nghiệm
    recruitInterview.setEnglishPoint(request.getEnglishPoint()); // Đánh giá trình độ tiếng anh
    recruitInterview.setAcquisitivenessPoint(request.getAcquisitivenessPoint()); // Đánh giá kĩ năng tiếp thu
    recruitInterview.setPresentationPoint(request.getPresentationPoint()); // Đánh giá kĩ năng  trình bày
    recruitInterview.setBargainingPoint(request.getBargainingPoint()); // Đánh giá kĩ năng thương lượng
    recruitInterview.setJudgmentPoint(request.getJudgmentPoint()); // Đánh giá kĩ năng phán đoán
    recruitInterview.setCommunicationPoint(request.getCommunicationPoint()); // Đánh giá kĩ năng giao tiếp
    recruitInterview.setManagementPoint(request.getManagementPoint()); // Đánh giá kĩ năng quản lý
    recruitInterview.setLogicPoint(request.getLogicPoint()); // Đánh giá tư duy logic
    recruitInterview.setPersonalityPoint(request.getPersonalityPoint()); // Tính cách
    recruitInterview.setConfidentPoint(request.getConfidentPoint()); // Sự tự tin
    recruitInterview.setDressPoint(request.getDressPoint()); // Trang phục
    recruitInterview.setVoicePoint(request.getVoicePoint()); // Giọng nói
    recruitInterview.setAttachmentPoint(request.getAttachmentPoint()); // Sự gắn bó với cty
    recruitInterview.setWorkEnvironmentPoint(request.getWorkEnvironmentPoint()); // Hiểu biết về môi trường làm việc
    recruitInterview.setPressurePotentialPoint(request.getPressurePotentialPoint()); // Áp lực công việc
    recruitInterview.setOvertimePotentialPoint(request.getOvertimePotentialPoint()); // Sẵn sàng OT
    recruitInterview.setGeneralReview(request.getGeneralReview()); // Đánh giá chung
    recruitInterview.setResult(request.getResult()); // Kết quả
    recruitInterview.setSalaryExpect(request.getSalaryExpect()); // mức lương mong muốn
    recruitInterview.setNotePV(request.getNotePV());
    recruitInterview.setNoteKQ(request.getNoteKQ());
    recruitInterview.setNoteKL(request.getNoteKL());
    recruitInterview.setStatusKQ(request.getStatusKQ());
    recruitInterview.setStatusPV(request.getStatusPV());
    recruitInterview.setStatusKL(request.getStatusKL());
    recruitInterview.setTime(request.getTime());
    recruitInterview.setType(request.getType());
    recruitInterview.setSalaryExpect(request.getSalaryExpect());
    recruitInterview.setSalaryIncreaseExpect(request.getSalaryIncreaseExpect());
    recruitInterview.setSalaryDeal(request.getSalaryDeal());

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
