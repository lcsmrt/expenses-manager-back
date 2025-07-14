package com.lcs.finsight.exceptions;

import java.util.List;

public class ErrorResponseDto {

    private final String message;
    private final String path;
    private List<FieldErrorDto> fieldErrors;

    public ErrorResponseDto(String message, String path) {
        this.message = message;
        this.path = path;
    }

    public ErrorResponseDto(String message, String path, List<FieldErrorDto> fieldErrors) {
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }


    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }
}