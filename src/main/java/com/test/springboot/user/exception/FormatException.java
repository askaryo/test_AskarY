package com.test.springboot.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

public class FormatException extends ResponseStatusException {
    public FormatException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Field's format error");
        Logger.getAnonymousLogger().info("Field's format error");

    }
}
