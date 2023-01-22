package com.brinksdevs.crudbasic.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found by id: " + id);
    }
}
