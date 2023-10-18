package com.example.exception;

public class APIClientException extends RuntimeException {
    public APIClientException(String message, Exception exception){
        super(message,exception);
    }
    public APIClientException(String message){
        super(message);
    }
}
