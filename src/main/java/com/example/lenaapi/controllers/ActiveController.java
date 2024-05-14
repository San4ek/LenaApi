package com.example.lenaapi.controllers;

import com.example.lenaapi.models.ActiveForSaveModel;
import com.example.lenaapi.models.ActiveForSendSmallModel;
import com.example.lenaapi.models.ActiveForSendFullModel;
import com.example.lenaapi.services.ActiveService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/active")
@AllArgsConstructor
public class ActiveController {

    private final ActiveService activeService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ActiveForSendSmallModel> getAll() {
        return activeService.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ActiveForSendFullModel getById(@RequestParam Long id) {
        return activeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Long save(@RequestBody @Valid ActiveForSaveModel activeForSaveModel) {
        return activeService.save(activeForSaveModel).getId();
    }
}
