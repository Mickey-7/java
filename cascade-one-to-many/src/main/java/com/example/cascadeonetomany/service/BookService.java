package com.example.cascadeonetomany.service;

import com.example.cascadeonetomany.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
    public Book deleteBook(Book book);
}
