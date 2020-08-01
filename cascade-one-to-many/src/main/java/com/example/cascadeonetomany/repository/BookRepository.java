package com.example.cascadeonetomany.repository;

import com.example.cascadeonetomany.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {
    public Book findByBookId(int bookId);
}
