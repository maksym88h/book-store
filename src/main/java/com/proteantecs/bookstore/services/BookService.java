package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Book;

import java.util.List;
import java.util.function.Predicate;


public interface BookService {
    Book save(Book book);
    List<Book> findAll();
    //void update(long id, String name, Double price, String cover, String description);
    Book deleteById(Long id);
    Book findByName(String name);
}
