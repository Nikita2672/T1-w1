package com.example.hw1.aspects;

import com.example.hw1.model.MethodExecution;
import com.example.hw1.service.MethodExecutionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@RequiredArgsConstructor
@Component
public class TrackTimeAspect {

    private final MethodExecutionService methodExecutionService;

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.example.hw1.annotations.TrackTime)")
    public void callAtMethodCalled() {
    }

    @Before("callAtMethodCalled()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        startTime.set(System.currentTimeMillis());
    }

    @After("callAtMethodCalled()")
    public void afterCallAt(JoinPoint jp) {
        MethodExecution methodExecution = new MethodExecution();
        methodExecution.setMethodName(jp.getSignature().toLongString());
        methodExecution.setDuration(System.currentTimeMillis() - startTime.get());
        methodExecutionService.saveMethod(methodExecution);
    }
}
