package com.sample.boilerplate.exceptions;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private ZonedDateTime dateTime;
    private List<FieldError> fieldErrors;

    public ApiError(HttpStatus httpStatus, String message, ZonedDateTime dateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.dateTime = dateTime;
    }

    public ApiError(HttpStatus httpStatus, String message, ZonedDateTime dateTime, List<FieldError> fieldErrors) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.dateTime = dateTime;
        this.fieldErrors = fieldErrors;
    }
}
