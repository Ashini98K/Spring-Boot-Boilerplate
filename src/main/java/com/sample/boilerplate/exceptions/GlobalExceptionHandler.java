package com.sample.boilerplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
