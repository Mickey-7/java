package com.example.service2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-2")
public class Service2Controller {




        @RequestMapping("/hello")
        public String hello() {

            return "Hello from Service 2";
        }


}
