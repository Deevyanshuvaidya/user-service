package com.example.user_service.exception;

public class ResourcenotFoundException extends RuntimeException {
    public ResourcenotFoundException(String msg){
        super(msg);
    }
    
}
