package com.sample.boilerplate.exceptions;

/**
 * Class that represents RecordNotFoundException
 */
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
