package com.example.cascadeonetomany.service;

import com.example.cascadeonetomany.domain.Book;
import com.example.cascadeonetomany.repository.BookRepository;
import com.example.cascadeonetomany.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StoryRepository storyRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book saveBook(Book book) {
        book = bookRepository.save(book);
        return book;
    }

    @Override
    public Book findByBookId(int bookId) {
        Optional<Book> bookResponse = bookRepository.findById(bookId);
        Book book = bookResponse.get();
        return book;
    }

    @Override
    public Book deleteBook(Book book) {
        bookRepository.delete(book);
        return book;
    }
}
