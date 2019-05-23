package com.music.tagger.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException( String message) {
        super(message);
    }

    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
