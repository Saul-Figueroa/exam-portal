package com.exam.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(Class<?> entityClass, Object id) {
        super(String.format("%s with id %s already exists in our system", entityClass.getSimpleName(), id));
    }
}
