package com.caito.userservice.exeption.custom;

public class EmptyImputException extends RuntimeException{

    public EmptyImputException(String error){
        super(error);
    }
}
