package com.example.hw1.service.impl;

import com.example.hw1.model.MethodExecution;
import com.example.hw1.repository.MethodExecutionRepository;
import com.example.hw1.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final MethodExecutionRepository methodExecutionRepository;

    @Override
    public MethodExecution getMaxDurationMethod() {
        return methodExecutionRepository.findMethodExecutionsWithMaxDuration();
    }

    @Override
    public MethodExecution getMinDurationMethod() {
        return methodExecutionRepository.findMethodExecutionsWithMinDuration();
    }

    @Override
    public Double getAverageDuration() {
        return methodExecutionRepository.findAverageDuration();
    }
}
