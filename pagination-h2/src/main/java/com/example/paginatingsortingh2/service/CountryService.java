package com.example.paginatingsortingh2.service;

import com.example.paginatingsortingh2.domain.Country;

import java.util.List;

public interface CountryService {
    List<Country> findPaginated(int pageNo, int pageSize);
}
