package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends ResponseStatusException {
    public BookNotFoundException(long id){
        super(HttpStatus.NOT_FOUND, "Book with id: " + id + " cannot be found!");
    }
}
