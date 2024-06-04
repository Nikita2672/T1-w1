package com.example.hw1.controller;

import com.example.hw1.model.MethodExecution;

import com.example.hw1.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/max")
    public MethodExecution getMaxTimeMethod() {
        return statisticService.getMaxDurationMethod();
    }

    @GetMapping("/min")
    public MethodExecution getMinTimeMethod() {
        return statisticService.getMinDurationMethod();
    }

    @GetMapping("/average")
    public Double getAverageDurationTime() {
        return statisticService.getAverageDuration();
    }
}
