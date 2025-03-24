package com.exam.role;

public class RoleAlreadyExistsException extends RuntimeException{

    public RoleAlreadyExistsException() {
        super("Role already exists in out system");
    }

    public RoleAlreadyExistsException(String message) {
        super(message);
    }

    public RoleAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}

