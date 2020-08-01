package com.example.cascadeonetomany.controller;

import com.example.cascadeonetomany.domain.Book;
import com.example.cascadeonetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/saveBook")
    public Book saveBook(@RequestBody Book book){
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        Book bookResponse = (Book) bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping( "/delete")
    public Book deleteBook(@RequestBody Book book) {
        Book bookResponse = (Book) bookService.deleteBook(book);
        return bookResponse;
    }

    @RequestMapping("/{bookId}")
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);

        return bookResponse;
    }


}
