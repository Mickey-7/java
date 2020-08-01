package com.example.cascadeonetomany.repository;

import com.example.cascadeonetomany.domain.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public interface StoryRepository extends CrudRepository<Story, Serializable> {
}
