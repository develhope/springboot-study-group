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

import java.util.Collection;

@Tag(name = "Book v2", description = "The Book API v2")
public interface BookControllerInterface {

    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a book by ID", description = "Returns an existing book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book with this ID does not exist", content = @Content),
//            @ApiResponse(responseCode = "404", description = "Book with this ID does not exist", content =
//                    {
//                            @Content(mediaType = "application/json", schema =
//                            @Schema(implementation = BookNotFoundException.class))
//                    }),
    })
    ResponseEntity<BookDtoV2> findById(@Parameter(name = "id", description = "Book id", example = "123", required = true) @PathVariable long id);

    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns a list of books", description = "Returns a list of found books")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok",
                            content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDto.class)))})
            })
    Collection<BookDtoV2> findBooks();

    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New book created!")
    })
    @Operation(summary = "Creates a book", description = "Returns a created book")
    ResponseEntity<BookDtoV2> updateBook(@RequestBody final CreateBookRequestDto request);

}
