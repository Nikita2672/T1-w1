package com.example.hw1.aspects;

import com.example.hw1.model.MethodExecution;
import com.example.hw1.service.MethodExecutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final MethodExecutionService methodExecutionService;

    private final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.example.hw1.annotations.TrackTime)")
    public void callAtMethodCalled() {
    }

    @Before("callAtMethodCalled()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        startTimeThreadLocal.set(System.currentTimeMillis());
    }

    @After("callAtMethodCalled()")
    public void afterCallAt(JoinPoint jp) {
        Long startTime = startTimeThreadLocal.get();
        if (startTime != null) {
            startTimeThreadLocal.remove();
            long endTime = System.currentTimeMillis();
            MethodExecution methodExecution = new MethodExecution();
            methodExecution.setMethodName(jp.getSignature().toLongString());
            methodExecution.setDuration(endTime - startTime);
            try {
                methodExecutionService.saveMethod(methodExecution);
                log.info("Saved method execution time: {} ms for {}",
                        methodExecution.getDuration(), methodExecution.getMethodName());
            } catch (Exception e) {
                log.error("Failed to save method execution time: {}", e.getMessage(), e);
            }
        }
    }
}
