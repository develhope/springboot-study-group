package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class CreateBookRequestDto {

    @Schema(description = "Book description", name = "description", type = "string", example = "Best book description ever!")
    String description;

    public String getDescription() {
        return description;
    }

    @NotNull
    @Schema(description = "Book name", name = "name", type = "string", example = "Best book name ever!")
    String name;

    public String getName() {
        return name;
    }
}
