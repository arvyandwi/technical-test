package com.technicalTest.technicaltest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameAlreadyExistAuthenticationException extends ResponseStatusException {
    public UsernameAlreadyExistAuthenticationException(HttpStatus http, String message) {
        super(http, message);
    }
}
