package com.example.paginatingsortingh2.controller;

import com.example.paginatingsortingh2.domain.Country;
import com.example.paginatingsortingh2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{pageNo}/{pageSize}")
    public List<Country> getPaginatedCountries(@PathVariable int pageNo, @PathVariable int pageSize){
        return countryService.findPaginated(pageNo, pageSize);
    }
}
