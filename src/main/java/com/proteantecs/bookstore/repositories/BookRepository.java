package com.proteantecs.bookstore.repositories;

import com.proteantecs.bookstore.domain.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>, QuerydslPredicateExecutor<Book> {

    //@Modifying
    @Transactional
    @Query("UPDATE Book b SET b.name = :name, b.price = :price, b.cover = :cover, b.description = :description " +
            "WHERE b.id = :id")
    Book update(@Param("id") Long id,
                @Param("name") String name,
                @Param("price") Double price,
                @Param("cover") String cover,
                @Param("description") String description);
}
