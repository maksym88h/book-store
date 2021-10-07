package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.services.BookService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.function.Predicate;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookEndpoint extends ResourceRepositoryBase<Book, Long> {

    private final BookService bookService;

    public BookEndpoint(BookService bookService) {
        super(Book.class);
        this.bookService = bookService;
    }

    @Override
    public ResourceList<Book> findAll(QuerySpec querySpec) {
        var books = bookService.findAll();
        var meta = new DefaultPagedMetaInformation();
        meta.setTotalResourceCount((long) books.size());
        return new DefaultResourceList<>(books, meta, new DefaultPagedLinksInformation());
    }

    @Override
    public <S extends Book> S save(S resource) {
        return (S) bookService.save(resource);
    }

    @Override
    public void delete(Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/findByName")

    public Book findByName(@RequestBody Book book) {
        log.info("The method find by name works");
        Book newBook = bookService.findByName(book.getName());
        return newBook;
    }

}
