package com.proteantecs.bookstore.repositories;

import com.proteantecs.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

}
