package com.example.demo.dtos.candidates;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDashboardDTO {
  Integer totalCandidate;
  Integer candidatePassCV;
  Integer candidateFailedCV;
  Integer candidateAdmitted;
  Integer candidateFailed;

  Double candidatePassCVPercent;
  Double candidateAdmittedPercent;


}
