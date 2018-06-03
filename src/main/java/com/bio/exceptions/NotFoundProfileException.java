package com.bio.exceptions;

@SuppressWarnings("serial")
public class NotFoundProfileException extends Exception {
    public NotFoundProfileException() {
        super();
    }

    public NotFoundProfileException(String message) {
        super(message);
    }
}
