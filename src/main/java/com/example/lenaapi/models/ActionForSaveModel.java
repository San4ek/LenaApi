package com.example.lenaapi.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActionForSaveModel {

    private Long activeId;

    @NotNull(message = "Fill all fields")
    private Date dateTime;

    private int state;

}
