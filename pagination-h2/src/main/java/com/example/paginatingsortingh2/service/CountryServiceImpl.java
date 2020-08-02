package com.example.paginatingsortingh2.service;

import com.example.paginatingsortingh2.domain.Country;
import com.example.paginatingsortingh2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = countryRepository.findAll(paging);
        return pagedResult.toList();
    }
}
