package com.example.demo;

public class CustomBodyBookNotFoundException extends RuntimeException {

    public CustomBodyBookNotFoundException(long id) {
        super("Book with id: " + id + " cannot be found!");
        this.id = id;

    }

    public long id;

    public long getId() {
        return id;
    }

}
