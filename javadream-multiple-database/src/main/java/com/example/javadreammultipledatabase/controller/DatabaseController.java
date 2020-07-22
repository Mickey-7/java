package com.example.javadreammultipledatabase.controller;

import com.example.javadreammultipledatabase.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//6.Create a controller class that is used to declare an rest endPoint .
@RestController
public class DatabaseController {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/")
    public String test(){
        try{
            int saveStatus = databaseService.save();
            logger.info("saveStatus= "+saveStatus);
            if (saveStatus == 1){
                return "Nice Try Champ !!";
            }else {
                return "Some Technical Error Please Try Again";
            }
        }catch (Exception e){
            logger.error("Exception: "+ e);
            return "Some Technical Error Please Try Again";
        }
    }

}
