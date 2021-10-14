package com.proteantecs.bookstore.services;

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

    @PersistenceContext
    private EntityManager entityManager;
    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book save(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("Didn't find element with id: {findOne Book}"));
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {;
               bookRepository.delete(findOne(id));
    }

    @Override
    public Book findOneByName(String name) {
        var qBook = QBook.book;
        var query = new JPAQuery(entityManager);
        query.from(qBook).where(qBook.name.eq(name)).distinct();
        var c1 = query.fetch();
        return (Book) c1.get(0);
    }
}
