package com.fabrick.test.exception;

public class ResponseModel {
    private final String code;
    private final String description;

    public ResponseModel(String code, String message) {
        this.code = code;
        this.description = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return description;
    }
}
