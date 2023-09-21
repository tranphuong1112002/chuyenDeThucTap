package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    MALE("MALE", "Nam"), FEMALE("FEMALE", "Nữ");

    private final String code;
    private final String name;
}

