package com.technicalTest.technicaltest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserActiveException extends ResponseStatusException {
    public UserActiveException(HttpStatus http, String message) {
        super(http, message);
    }
}
