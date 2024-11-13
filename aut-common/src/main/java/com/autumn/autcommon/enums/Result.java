package com.autumn.autcommon.enums;

import lombok.Getter;

@Getter
public enum Result {
    SUCCESS(200,""),

    FAIL(500, "");

    private final int code;
    private final String message;

    Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
