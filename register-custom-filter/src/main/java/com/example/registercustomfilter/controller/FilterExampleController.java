package com.example.registercustomfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterExampleController {
    @GetMapping
    public String greeting(){
        return "hello world";
    }


    @GetMapping("/greeting")
    public String customGreeting(){
        return "hello from custom greeting";
    }
}
