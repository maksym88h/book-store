package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.services.BookService;
import io.crnk.core.engine.registry.ResourceRegistry;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class BookEndpoint extends ResourceRepositoryBase<Book, Long> {

    private final BookService bookService;

    public BookEndpoint(BookService bookService) {
        super(Book.class);
        this.bookService = bookService;
    }

    @Override
    public ResourceList<Book> findAll(QuerySpec querySpec) {
        return querySpec.apply(bookService.findAll());
    }

    @Override
    public Class<Book> getResourceClass() {
        return Book.class;
    }

    @Override
    public Book findOne(Long id, QuerySpec querySpec) {
        return bookService.findOne(id);
    }

    @Override
    public <S extends Book> S save(S resource) {
        System.out.println();
        return (S) bookService.save(resource.getId(), resource);
    }

    @Override
    public <S extends Book> S create(S resource) {
        System.out.println();
        return (S) bookService.create(resource);
    }

    @Override
    public void delete(Long id) {
        bookService.delete(id);
    }

    @GetMapping("/findBookByName")
    public Book findByName(@RequestBody Book book) {
        Book newBook = bookService.findOneByName(book.getName());
        return newBook;
    }
}