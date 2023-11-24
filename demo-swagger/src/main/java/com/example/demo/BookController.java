package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book", description = "The Book API")
public class BookController {

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a book by ID", description = "Returns an existing book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
//            @ApiResponse(responseCode = "404", description = "Book with this ID does not exist", content = @Content),
//            @ApiResponse(responseCode = "404", description = "Book with this ID does not exist", content =
//                    {
//                            @Content(mediaType = "application/json", schema =
//                            @Schema(implementation = String.class))
//                    }),
    })
    public ResponseEntity<BookDto> findById(@Parameter(name = "id", description = "Book id", example = "123", required = true) @PathVariable long id) {
        if (id % 2 == 1) {
            return ResponseEntity.ok(new BookDto(id, "Invented name!"));
        } else {
            throw new CustomBodyBookNotFoundException(id);
        }
    }

    @ExceptionHandler(CustomBodyBookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiResponse(responseCode = "404", description = "Book with this ID does not exist", content =
            {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = String.class))
            })
    public ResponseEntity<String> handleCustomBodyBookNotFoundException(CustomBodyBookNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a list of books", description = "Returns a list of found books")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = BookDto.class)))})
            })
    public Collection<BookDto> findBooks() {
        return new ArrayList<BookDto>();
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Creates a book by ID", description = "Returns a created book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New book created!")
    })
    public ResponseEntity<BookDto> createBook(@RequestBody final CreateBookRequestDto request) {
        long id = new Random().nextLong();
        System.out.println("Called book with id " + id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BookDto(id, request.name));
    }
}
