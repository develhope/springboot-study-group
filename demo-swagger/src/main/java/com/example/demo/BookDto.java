package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class BookDto {

    public BookDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Schema(description = "Book id", name = "id", type = "long", example = "123")
    @NotNull
    long id;

    public long getId() {
        return id;
    }

    @Schema(description = "Book name", name = "name", type = "string", example = "Best book ever!")
    @NotNull
    String name;

    public String getname() {
        return name;
    }
}
