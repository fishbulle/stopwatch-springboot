package com.example.tidtagarur;

public class NotFoundException extends Exception {
    public NotFoundException(String id) {
        super(id);
    }
}
