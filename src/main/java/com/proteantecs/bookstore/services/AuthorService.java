package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.domain.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    Author save(Long id, Author author);

    Author findOne(Long id);

    List<Author> findAll();

    void delete(Long bookId);

    Author findOneByName(String name);

}
