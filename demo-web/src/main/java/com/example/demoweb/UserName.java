package com.example.demoweb;

import jakarta.validation.constraints.NotNull;

public class UserName {

    public UserName(String name) {
        this.name = name;
    }

    @NotNull public String name;
}
