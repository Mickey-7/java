package com.example.forgotpassword.controller;

import com.example.forgotpassword.domain.User;
import com.example.forgotpassword.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String password){
        System.out.println(token);
        System.out.println(password);
        return userService.resetPassword(token,password);
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email){
        System.out.println(email);
        String response  = userService.forgotPassword(email);
        if (!response.startsWith("Invalid")){
            response = "http://localhost:8080/reset-password?token="+response;
        }
        System.out.println(email);
        return response;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
}
