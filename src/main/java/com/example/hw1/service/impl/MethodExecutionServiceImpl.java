package com.example.hw1.service.impl;

import com.example.hw1.model.MethodExecution;
import com.example.hw1.repository.MethodExecutionRepository;
import java.util.concurrent.CompletableFuture;

import com.example.hw1.service.MethodExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MethodExecutionServiceImpl implements MethodExecutionService {

    private final MethodExecutionRepository methodExecutionRepository;

    @Override
    public void saveMethod(MethodExecution methodExecution) {
        CompletableFuture.runAsync(() -> methodExecutionRepository.save(methodExecution));
    }
}
