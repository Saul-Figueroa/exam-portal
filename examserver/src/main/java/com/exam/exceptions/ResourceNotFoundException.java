package com.exam.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> entityClass, Object id) {
        super(String.format("%s with id %s was not found", entityClass.getSimpleName(), id));
    }
}
