package com.example.demo.exceptions;

import java.util.List;
import lombok.*;

/**
 * @author duongnhathuy
 * @version 1.0
 * @since 15/09/2021 Class CrmException kế thừa Exception phục vụ việc xử lý và tổng hợp lỗi trong
 * sourceCode CRM.
 */
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RCException extends RuntimeException {

  private String messageKey;
  private String message;

  public RCException(String msgKey) {
    this.messageKey = msgKey;
    this.message = String.format(ExceptionUtils.MESSAGES.get(this.messageKey));
  }

  public RCException(String msgKey, String msg) {
    this.messageKey = msgKey;
    this.message = msg;
  }
}