package com.proteantecs.bookstore.services;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.repositories.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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



//    @Override
//    public void update(long id, String name, Double price, String cover, String description) {
//        Book byId = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book nyma"));
//        bookRepository.update(id, name, price, cover, description);
//    }

    @Override
    public Book deleteById(Long id) {
        Book byId = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return byId;
    }
}
