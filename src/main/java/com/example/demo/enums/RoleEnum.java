package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
  ADMIN("ADMIN", "Quản trị viên"),
  HR("HR", "Quản trị nhân lực"),
  CANDIDATE("CANDIDATE", "Ứng viên");

  private final String code;
  private final String name;
}
