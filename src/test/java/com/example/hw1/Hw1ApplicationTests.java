package com.example.hw1;

import com.example.hw1.example.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Hw1ApplicationTests {
    @Autowired
    ExampleService exampleService;

    @Test
    void contextLoads() {
        exampleService.method1();
        exampleService.method2();
    }

}
