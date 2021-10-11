package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.domain.QAuthor;
import com.proteantecs.bookstore.repositories.AuthorRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author save(Author author) {

        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author deleteById(Long id) {
        Author authorById = authorRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can't delete author"));
        authorRepository.delete(authorById);
        return authorById;
    }

    @Override
    public Author findByName(String firstName) {
        QAuthor qAuthor = QAuthor.author;
        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        query.from(qAuthor).where(qAuthor.firstName.eq(firstName)).distinct();
        List<Object> b1 = query.fetch();
        return (Author) b1.get(0);
    }
}
