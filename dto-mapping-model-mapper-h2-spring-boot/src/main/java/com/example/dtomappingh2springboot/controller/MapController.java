package com.example.dtomappingh2springboot.controller;

import com.example.dtomappingh2springboot.dto.UserLocationDTO;
import com.example.dtomappingh2springboot.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MapController {
    @Autowired
    private MapService mapService;

    @GetMapping()
    public List<UserLocationDTO> getAllUsersLocation(){
        return mapService.getAllUserLocation();
    }


}
