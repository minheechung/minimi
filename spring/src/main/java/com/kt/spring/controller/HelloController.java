package com.kt.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/")
    public String HelloMini() {
        return "Hello, Mini!";
    }
    


}
