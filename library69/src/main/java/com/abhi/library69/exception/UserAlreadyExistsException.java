package com.abhi.library69.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){

        super(message);
    }

    public UserAlreadyExistsException(){

    }
}
