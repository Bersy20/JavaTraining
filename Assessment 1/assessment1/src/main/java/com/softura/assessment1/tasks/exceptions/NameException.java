package com.softura.assessment1.tasks.exceptions;

public class NameException extends Exception {
    public NameException(){
        super("User Name already Exists...");
    }
}
