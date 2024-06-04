package com.example.hw1.service;

import com.example.hw1.model.MethodExecution;

public interface StatisticService {

    MethodExecution getMaxDurationMethod();

    MethodExecution getMinDurationMethod();

    Double getAverageDuration();
}
