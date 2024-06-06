package com.example.hw1.aspects;

import com.example.hw1.model.MethodExecution;
import com.example.hw1.service.MethodExecutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@Log4j2
@RequiredArgsConstructor
public class TrackTimeAsyncAspect {

    private final MethodExecutionService methodExecutionService;
    private final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @Around("@annotation(com.example.hw1.annotations.TrackAsyncTime) && @annotation(org.springframework.scheduling.annotation.Async)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        startTimeThreadLocal.set(System.currentTimeMillis());
        try {
            Object result = joinPoint.proceed();
            if (result instanceof CompletableFuture<?>) {
                return handleCompletableFuture(joinPoint, (CompletableFuture<?>) result);
            } else {
                logExecutionTime(joinPoint);
                return result;
            }
        } catch (Throwable throwable) {
            logExecutionTime(joinPoint);
            throw throwable;
        }
    }

    private CompletableFuture<?> handleCompletableFuture(ProceedingJoinPoint joinPoint, CompletableFuture<?> future) {
        return future.whenComplete((res, ex) -> {
            logExecutionTime(joinPoint);
        });
    }

    private void logExecutionTime(ProceedingJoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        MethodExecution methodExecution = new MethodExecution();
        methodExecution.setMethodName(joinPoint.getSignature().toLongString());
        methodExecution.setDuration(executionTime);
        methodExecutionService.saveMethod(methodExecution);
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        startTimeThreadLocal.remove();
    }
}
