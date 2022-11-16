package com.test.springboot.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

public class UsernameUsedException extends ResponseStatusException {

    public UsernameUsedException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Username already used");
        Logger.getAnonymousLogger().info("Username already used");
    }
}
