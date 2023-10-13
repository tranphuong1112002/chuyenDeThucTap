package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
  TAO_MOI("TAO_MOI", "Tạo mới"),
  DANH_GIA("DANH_GIA", "Đánh giá CV"),
  LH("LH", "Liên hệ ứng viên"),
  PV("PV", "Phỏng vấn"),
  TV("TV", "Tham vấn lương"),
  OFFER("OFFER", "Nhận offer"),
  CANCEL("CANCEL", "Từ chối");

  private final String code;
  private final String name;
}
