package com.example.demo.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utils class");
    }

    // chuyển tiếng việt có dấu thành không dấu
    public static String convertToString(String value) {
        String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace("đ", "d").replace("Đ", "D");
    }

    // lấy tên không dấu phục vụ tìm kiếm
    public static String getFullNameUnsighted(String lastName, String firstName) {
        return Utils.convertToString(lastName) + " " + Utils.convertToString(firstName);
    }

    // lấy tên đầy đủ
    public static String getFullName(String lastName, String firstName) {
        return lastName + " " + firstName;
    }
}
