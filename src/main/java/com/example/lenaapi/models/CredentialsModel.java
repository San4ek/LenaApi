package com.example.lenaapi.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialsModel {

    @NotNull(message = "Login and password should be not empty")
    @Size(min = 4, max = 16, message = "Login and password length should be between 4 and 16 characters")
    private String login;

    @NotNull(message = "Login and password should be not empty")
    @Size(min = 4, max = 16, message = "Login and password length should be between 4 and 16 characters")
    private String password;

    private boolean isBlocked;
}
