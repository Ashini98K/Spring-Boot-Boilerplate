package com.sample.boilerplate.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FieldError {
    private String field;
    private String errorCode;
}
