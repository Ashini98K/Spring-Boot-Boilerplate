package com.sample.boilerplate.exceptions;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private ZonedDateTime dateTime;

    public ApiError(HttpStatus httpStatus, String message, ZonedDateTime dateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.dateTime = dateTime;
    }
}
