package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ExceptionUtils {

  public static final String E_INTERNAL_SERVER = "E_INTERNAL_SERVER";
  public static final String E_RECORD_NOT_EXIST = "E_RECORD_NOT_EXIST";
  public static final String E_NOT_FOUND_PATH = "E_NOT_FOUND_PATH";

  public static final Map<String, String> MESSAGES = Map.of(
          E_INTERNAL_SERVER, "Server không phản hồi",
          E_RECORD_NOT_EXIST, "Bản ghi không tồn tại",
          E_NOT_FOUND_PATH, "Đường dẫn không tồn tại"
  );

  private ExceptionUtils() {
    throw new IllegalStateException("ExceptionUtils class");
  }
}
