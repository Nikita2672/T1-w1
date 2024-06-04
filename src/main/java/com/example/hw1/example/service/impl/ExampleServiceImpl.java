package com.example.hw1.example.service.impl;

import com.example.hw1.annotations.TrackAsyncTime;
import com.example.hw1.annotations.TrackTime;
import com.example.hw1.example.service.ExampleService;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    @TrackTime
    public void method1() {
        // just for different duration values
        try {
            Thread.sleep((long) (Math.random() * 100));
            System.out.println("method 1");
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @TrackAsyncTime
    public void method2() {
        // just for different duration values
        try {
            Thread.sleep((long) (Math.random() * 100));
            System.out.println("method 2");
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
