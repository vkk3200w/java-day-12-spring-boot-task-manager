package com.example.day12api.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello World! Welcome to Spring Boot.";
    }
}
