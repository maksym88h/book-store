package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.repositories.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book update(Book book) {
//        Book byId = bookRepository.findById(book.getId()).orElse( null);
//        book.setId(byId.getId());
        return null;
    }

    @Override
    public Book deleteById(Long id) {
        Book byId = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return byId;
    }
}
