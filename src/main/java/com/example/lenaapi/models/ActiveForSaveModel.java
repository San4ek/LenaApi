package com.example.lenaapi.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActiveForSaveModel {

    private Long id;

    @NotNull(message = "Active name should be not empty")
    @Size(min = 4, max = 16, message = "Active name length should be between 4 and 16 characters")
    private String name;

    @NotNull(message = "Choose worker")
    private int worker;

    @NotNull(message = "Choose type")
    private int type;
}
