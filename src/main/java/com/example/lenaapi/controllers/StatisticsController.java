package com.example.lenaapi.controllers;

import com.example.lenaapi.models.StatisticsModel;
import com.example.lenaapi.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController {

    private StatisticsService statisticsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StatisticsModel> getAll() {
        return statisticsService.getAll();
    }
}
