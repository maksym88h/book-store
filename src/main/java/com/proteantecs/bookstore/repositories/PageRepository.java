package com.proteantecs.bookstore.repositories;

import com.proteantecs.bookstore.domain.Page;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends CrudRepository<Page,Long>, QuerydslPredicateExecutor<Page> {
}
