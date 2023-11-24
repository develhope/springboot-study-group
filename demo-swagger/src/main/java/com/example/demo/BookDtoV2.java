package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BookDtoV2(
        @Schema(description = "Book id", name = "id", type = "long", example = "123") @NotNull long id,
        @Schema(description = "Book name", name = "name", type = "string", example = "Best book ever!") @NotNull String name) {
}
