package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PermissionEnum {
  CREATE("CREATE", "Thêm mới"),
  UPDATE("UPDATE", "Cập nhật"),
  DELETE("DELETE", "Xoá"),
  READ("READ", "Xem");

  private final String code;
  private final String name;
}
