package com.fullstack.safeheaven.exception;

public class userNotFoundException  extends RuntimeException{
    public userNotFoundException(String name){
        super("not found the user with name " + name);
    }
}
