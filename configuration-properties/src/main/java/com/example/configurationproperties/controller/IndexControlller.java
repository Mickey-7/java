package com.example.configurationproperties.controller;

import com.example.configurationproperties.configuration.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexControlller {
    @Autowired
    private AppProperties appProperties;

    @GetMapping("/")
    public Map<String, String> getAppDetails(){
        Map<String, String> appDetails = new HashMap<>();
        appDetails.put("name",appProperties.getName());
        appDetails.put("description", appProperties.getDescription());
        return appDetails;
    }
}
