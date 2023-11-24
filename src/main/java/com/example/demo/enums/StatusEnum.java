package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
  TU_CHOI("TU_CHOI", "Từ chối"),
  DANH_GIA("DANH_GIA", "Đánh giá"),
  PHONG_VAN("PHONG_VAN", "Phỏng vấn"),
  THAM_GIA_PHONG_VAN("THAM_GIA", "Tham gia phỏng vấn"),
  KET_QUA_PHONG_VAN("OFFER", "Kết quả phỏng vấn"),
  KET_LUAN_TU_CHOI("KET_LUAN_TU_CHOI", "Kết luận từ chối"),
  KET_LUAN_DONG_Y("KET_LUAN_DONG_Y", "Kết luận đồng ý");


  private final String code;
  private final String name;
}
