package com.devcommunity.app.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException() {
        super("Current Item not found.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
