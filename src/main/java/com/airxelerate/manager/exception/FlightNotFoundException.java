package com.airxelerate.manager.exception;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(Integer id) {
        super("flight with id:" + id + " was not found");
    }

    public FlightNotFoundException(String fieldName, String value) {
        super("flight with" + fieldName + ": " + "value " + value + "was not found");
    }
}
