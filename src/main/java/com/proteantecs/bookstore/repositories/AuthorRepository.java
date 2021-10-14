package com.proteantecs.bookstore.repositories;

import com.proteantecs.bookstore.domain.Author;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long>, QuerydslPredicateExecutor<Author> {
}
