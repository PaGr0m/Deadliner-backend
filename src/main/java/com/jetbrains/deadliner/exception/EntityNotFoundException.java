package com.jetbrains.deadliner.exception;

public class EntityNotFoundException extends EntityException {
    public EntityNotFoundException(Object object, String message) {
        super(object, message);
    }
}