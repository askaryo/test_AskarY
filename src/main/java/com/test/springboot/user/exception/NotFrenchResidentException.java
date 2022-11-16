package com.test.springboot.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

public class NotFrenchResidentException extends ResponseStatusException {

    public NotFrenchResidentException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Need to be a french resident");
        Logger.getAnonymousLogger().info("Need to be a french resident");
    }
}
