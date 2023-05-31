package com.sample.boilerplate.exceptions;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Represents an error response model for API exceptions.
 */
@Getter
@Setter
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private ZonedDateTime dateTime;
    private List<FieldError> fieldErrors;

    /**
     * Constructs an instance of ApiError with HTTP status, message, and timestamp.
     * @param {HttpStatus} httpStatus - The HTTP status code of the error response
     * @param {String} message - A descriptive message for the error
     * @param {ZonedDateTime} dateTime - The timestamp when the error occurred
     */
    public ApiError(HttpStatus httpStatus, String message, ZonedDateTime dateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.dateTime = dateTime;
    }

    /**
     * Constructs an instance of ApiError with HTTP status, message, timestamp, and field errors.
     * @param {HttpStatus} httpStatus - The HTTP status code of the error response
     * @param {String} message - A descriptive message for the error
     * @param {ZonedDateTime} dateTime - The timestamp when the error occurred
     * @param {List<FieldError></>} fieldErrors A list of field-specific error details
     */
    public ApiError(HttpStatus httpStatus, String message, ZonedDateTime dateTime, List<FieldError> fieldErrors) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.dateTime = dateTime;
        this.fieldErrors = fieldErrors;
    }
}
