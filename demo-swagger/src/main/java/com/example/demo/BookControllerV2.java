package com.example.demo;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@RestController
@RequestMapping("/api/v2/book")
public class BookControllerV2 implements BookControllerInterface {

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BookDtoV2> findById(@PathVariable long id) {
        if (id % 2 == 1) {
            return ResponseEntity.ok(new BookDtoV2(id, "Invented name!"));
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    @GetMapping("/")
    public Collection<BookDtoV2> findBooks() {
        return new ArrayList<BookDtoV2>();
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<BookDtoV2> updateBook(@RequestBody final CreateBookRequestDto request) {
        long id = new Random().nextLong();
        System.out.println("Created book with id " + id + ", name: " + request.name);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BookDtoV2(id, request.name));
    }
}
