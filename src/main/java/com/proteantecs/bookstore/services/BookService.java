package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book save(Long id, Book book);

    Book findOne(Long id);

    List<Book> findAll();

    void delete(Long bookId);

    Book findOneByName(String name);

}
