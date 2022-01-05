package com.caito.userservice.exeption.custom;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }
}
