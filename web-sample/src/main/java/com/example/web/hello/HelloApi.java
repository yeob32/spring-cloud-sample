package com.example.web.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    static final Logger log = LoggerFactory.getLogger(HelloApi.class);

    @GetMapping("/hello")
    public String hello() {
        log.info("hello 8081 !");
        return "Hello World !!";
    }

    @GetMapping("/hello/latency")
    public String latency() {
        try {
            log.info("sleep 3 second");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Latency Hello !";
    }

    @GetMapping("/hello500")
    public void hello2() throws Exception {
        log.info("hello 500 !");
        throw new Exception();
    }
}
