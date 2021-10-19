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

    @PersistenceContext
    private EntityManager entityManager;
    private final AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author save(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @Override
    public Author findOne(Long id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Didn't find element with id: "+id));
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(findOne(id));
    }

    @Override
    public Author findOneByName(String name) {
        var qAuthor = QAuthor.author;
        var query = new JPAQuery(entityManager);
        query.from(qAuthor).where(qAuthor.lastName.eq(name)).distinct();
        var c1 = query.fetch();
        return (Author) c1.get(0);
    }
}
