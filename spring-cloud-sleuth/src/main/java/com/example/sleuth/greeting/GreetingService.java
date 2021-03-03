package com.example.sleuth.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

    private static final Logger log = LoggerFactory.getLogger(GreetingService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getHello() {
        log.info("access start !");
        String result = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        log.info("access end - result : {}", result);

        return result;
    }

    public String getLatencyHello() {
        log.info("access start !");
        String result = restTemplate.getForObject("http://localhost:8081/hello/latency", String.class);
        log.info("access end - result : {}", result);

        return result;
    }

    public String getHelloException() {
        log.info("access start !");
        String result = restTemplate.getForObject("http://localhost:8081/hello/hello500", String.class);
        log.info("access end - result : {}", result);

        return result;
    }
}
