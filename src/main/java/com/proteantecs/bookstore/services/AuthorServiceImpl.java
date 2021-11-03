package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.domain.QAuthor;
import com.proteantecs.bookstore.repositories.AuthorRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) repository.findAll();
    }

    @Override
    public Author deleteById(Long id) {
        var getAuthorById = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Author has not been found by id: "));
        return getAuthorById;
    }

    @Override
    public Author findById(Long id) {
        var qAuthor = QAuthor.author;
        var query = new JPAQuery(entityManager);
        query.from(qAuthor).where(qAuthor.id.eq(id)).distinct();
        var c1 = query.fetch();
        return (Author) c1.get(0);
    }

}
