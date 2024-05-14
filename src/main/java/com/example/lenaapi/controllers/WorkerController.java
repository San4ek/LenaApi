package com.example.lenaapi.controllers;

import com.example.lenaapi.models.WorkerForSendModel;
import com.example.lenaapi.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<WorkerForSendModel> getAll() {
        return workerService.getAll();
    }
}
