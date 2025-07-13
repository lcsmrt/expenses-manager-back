package com.lcs.finsight.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseDto {

    private final LocalDateTime timestamp;
    private final int status;
    private final String message;
    private final String path;
    private List<FieldErrorDto> fieldErrors;

    public ErrorResponseDto(LocalDateTime timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ErrorResponseDto(LocalDateTime timestamp, int status, String message, String path, List<FieldErrorDto> fieldErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
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