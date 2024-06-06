package com.example.hw1.example.controller;

import com.example.hw1.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/method1")
    public void callMethod1() {
        exampleService.method1();
    }

    @GetMapping("/method2")
    public void callMethod2() {
        exampleService.method2();
    }

    @GetMapping("/method3")
    public void callMethod3() {
        exampleService.method3();
    }
}
