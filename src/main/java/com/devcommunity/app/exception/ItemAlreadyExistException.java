package com.devcommunity.app.exception;

public class ItemAlreadyExistException extends RuntimeException{
    public ItemAlreadyExistException() {
        super("Item already exist in system.");
    }

    public ItemAlreadyExistException(String message) {
        super(message);
    }
}
