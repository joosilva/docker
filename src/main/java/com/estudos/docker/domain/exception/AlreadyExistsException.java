package com.estudos.docker.domain.exception;

public class AlreadyExistsException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public AlreadyExistsException (String message) {

        super(message);
    }

}
