package com.example.sleuth.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingApi {

    private final GreetingService greetingService;

    public GreetingApi(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return greetingService.getHello();
    }

    @GetMapping("/greeting2")
    public String greeting2() {
        return greetingService.getLatencyHello();
    }

    @GetMapping("/greeting3")
    public String greeting3() {
        return greetingService.getHelloException();
    }
}
