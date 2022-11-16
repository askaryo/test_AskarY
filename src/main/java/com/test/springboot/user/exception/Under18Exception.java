package com.test.springboot.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

public class Under18Exception extends ResponseStatusException {

    public Under18Exception() {
        super(HttpStatus.INTERNAL_SERVER_ERROR,"18 years old required");
        Logger.getAnonymousLogger().info("18 years old required");
    }
}
