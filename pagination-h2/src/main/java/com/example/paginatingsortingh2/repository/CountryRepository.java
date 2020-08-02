package com.example.paginatingsortingh2.repository;

import com.example.paginatingsortingh2.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
