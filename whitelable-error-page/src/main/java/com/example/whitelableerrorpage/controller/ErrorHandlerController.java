package com.example.whitelableerrorpage.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class ErrorHandlerController implements ErrorController {

    @GetMapping("error")
    public String customError(){
//        return "The link you followed may be broken, or the page may have benn removed.";
        return "error";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
