package com.caito.userservice.exeption.custom;

public class Forbidden extends RuntimeException{

    public Forbidden(String error){
        super(error);
    }
}
