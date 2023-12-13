package com.example.demo.dtos.candidates;

import com.example.demo.annotations.ExportExcel;
import com.example.demo.domains.Candidate;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CandidateExportDTO {

  @ExportExcel(title = "STT")
  private Integer cardinalNumber;

  @ExportExcel(title = "Mã UV")
  private String candidateCode;

  @ExportExcel(title = "Họ tên")
  private String fullName;

  @ExportExcel(title = "Số điện thoại")
  private String phoneNumber;

  @ExportExcel(title = "Email")
  private String email;

  @ExportExcel(title = "Ngày sinh")
  private String birthDate;
  @ExportExcel(title = "Trình độ")
  private String level;

  @ExportExcel(title = "Địa chỉ")
  private String address;
  @ExportExcel(title = "Số năm kinh nghiệm")
  private String numberOfExp;

  @ExportExcel(title = "Trạng thái")
  private String status;

  public CandidateExportDTO(int cardinalNumber, Candidate dto) {
    this.cardinalNumber = cardinalNumber;
    this.candidateCode = dto.getCandidateCode();
    this.fullName = dto.getCandidateCode();
    this.phoneNumber = dto.getPhone();
    this.email = dto.getEmail();
    this.address = dto.getAddress();
    this.birthDate = dto.getBirthDate().toString();
    this.level = dto.getLevel().name();
    this.numberOfExp = String.valueOf(dto.getNumberOfExp());
    this.status = String.valueOf(dto.getStatus().getName());
  }
}
