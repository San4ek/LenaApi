package com.example.lenaapi.controllers;

import com.example.lenaapi.models.ActionForSaveModel;
import com.example.lenaapi.models.ActionForSendModel;
import com.example.lenaapi.services.ActionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/action")
@AllArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody long save(@RequestBody @Valid ActionForSaveModel actionForSaveModel) {
        return actionService.save(actionForSaveModel);
    }
}
