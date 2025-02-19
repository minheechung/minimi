package com.kt.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/mini")
public class HelloController {
    @GetMapping("/hello")
    public String HelloMini() {
        System.out.println("gg>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "Hello, Mini!";
    } 





}
