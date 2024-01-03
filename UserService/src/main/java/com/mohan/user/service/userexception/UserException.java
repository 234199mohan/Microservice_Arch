package com.mohan.user.service.userexception;

public class UserException extends  RuntimeException{

    public UserException(){
        super("Resource Not Found on server !!!!!!!!!");
    }

    public UserException(String message){
    super(message);
    }
}
