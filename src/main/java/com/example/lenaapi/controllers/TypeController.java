package com.example.lenaapi.controllers;

import com.example.lenaapi.models.ActiveStateModel;
import com.example.lenaapi.services.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
public class TypeController {

    private TypeService typeService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ActiveStateModel> getAll() {
        List<ActiveStateModel> activeStateModels = typeService.getAll();
        System.out.println(activeStateModels);

        return activeStateModels;
    }

}
