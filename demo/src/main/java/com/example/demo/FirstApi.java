package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApi {

    @GetMapping("/")
    public String magePage() {
        return "하이";
    }

    @GetMapping("/hello")
    public String hello() {
        return "하이 유저";
    }
}
