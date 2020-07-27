package com.example.dtomappingh2springboot.repository;

import com.example.dtomappingh2springboot.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
