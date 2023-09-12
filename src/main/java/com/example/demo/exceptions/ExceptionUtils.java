package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ExceptionUtils {

    public static final Map<String, String> messages = new HashMap<>();

    static {
        messages.put("d", "d");
    }

    private ExceptionUtils() {
        throw new IllegalStateException("ExceptionUtils class");
    }
}
