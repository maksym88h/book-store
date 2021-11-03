package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.services.AuthorService;
import com.proteantecs.bookstore.services.BookService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;


@Slf4j
@Component
public class BookEndpoint extends ResourceRepositoryBase<Book, Long> {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookEndpoint(BookService bookService,AuthorService authorService) {
        super(Book.class);
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public ResourceList<Book> findAll(QuerySpec querySpec) {
        if (querySpec.getFilters().size() <= 0){
            return querySpec.apply(bookService.findAll());
        }
        else {
            Book bookByName = bookService.getBookByName(querySpec.getFilters().get(0).getValue().toString());
             return new DefaultResourceList<>(List.of(bookByName), new DefaultPagedMetaInformation(), new DefaultPagedLinksInformation());
        }
    }

    @Override
    public Book save(Book book) {
        return bookService.save(book);
    }

    @Override
    public void delete(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public Book findOne(Long id, QuerySpec querySpec) {
        return bookService.findOne(id);
    }

    @Override
    public ResourceList<Book> findAll(Collection<Long> ids, QuerySpec querySpec) {
        var books = bookService.findAll();
        return querySpec.apply(books);
    }
}
