package com.sample.boilerplate.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Field error class that is used to indicate attribute errors
 */
@Setter
@Getter
public class FieldError {
    private String field;
    private String errorCode;
}
