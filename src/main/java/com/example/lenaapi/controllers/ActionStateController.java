package com.example.lenaapi.controllers;

import com.example.lenaapi.models.ActiveStateModel;
import com.example.lenaapi.services.ActionStateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@AllArgsConstructor
public class ActionStateController {

    private ActionStateService actionStateService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ActiveStateModel> getAll() {
        return actionStateService.getAll();
    }

}
