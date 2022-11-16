package com.test.springboot.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

public class MissingFieldException extends ResponseStatusException {

    public MissingFieldException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Missing field");
        Logger.getAnonymousLogger().info("Missing field");
    }

}
