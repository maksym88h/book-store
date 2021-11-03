package com.proteantecs.bookstore.services;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.domain.QBook;
import com.proteantecs.bookstore.repositories.BookRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book deleteById(Long id) {
        Book byId = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book has not been found by id: "));
        bookRepository.deleteById(id);
        return byId;
    }

    @Override
    public Book getBookByName(String name) {
        var qBook = QBook.book;
        var query = new JPAQuery(entityManager);
        query.from(qBook).where(qBook.name.eq(name)).distinct();
        var c1 = query.fetch();
        return (Book) c1.get(0);
    }

    @Override
    public Book findOne(Long id) {
        var qBook = QBook.book;
        var query = new JPAQuery(entityManager);
        query.from(qBook).where(qBook.id.eq(id)).distinct();
        var c1 = query.fetch();
        return (Book) c1.get(0);
    }
}
