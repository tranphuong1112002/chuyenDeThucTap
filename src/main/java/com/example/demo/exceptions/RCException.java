package com.example.demo.exceptions;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RCException extends RuntimeException {

    private String messageKey;
    private String message;
    private Throwable throwable;
    private List<String> messages;

    public RCException(String msgKey) {
        this.messageKey = msgKey;
        this.message = String.format(ExceptionUtils.messages.get(this.messageKey));
    }

    public RCException(String msgKey, String msg) {
        this.messageKey = msgKey;
        this.message = msg;
    }

    @Override
    public String getMessage() {
        if (this.message != null) {
            return message;
        }
        if (this.messageKey != null) {
            this.message = String.format(ExceptionUtils.messages.get(this.messageKey));
        }
        return null;
    }
}
