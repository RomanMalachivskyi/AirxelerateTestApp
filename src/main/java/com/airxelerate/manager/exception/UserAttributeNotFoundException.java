package com.airxelerate.manager.exception;

public class UserAttributeNotFoundException extends RuntimeException {

    public UserAttributeNotFoundException(String username) {
        super("UserAttribute with username:" + username + " was not found");
    }
}
