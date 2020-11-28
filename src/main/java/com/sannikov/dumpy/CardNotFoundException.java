package com.sannikov.dumpy;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String message){
        super(message);
    }
}
