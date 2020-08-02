package com.example.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-1")
public class Service1Controller {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello from Service1";
    }
}
