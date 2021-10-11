package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Author;
import java.util.List;

public interface AuthorService {

    Author save(Author author);

    List<Author> findAll();

    Author deleteById(Long id);

    Author findByName(String firstName);

}
