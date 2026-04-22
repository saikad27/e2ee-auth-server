package com.example.e2ee_auth_server.exception;



public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(){
        super("User already exists");
    }
}
