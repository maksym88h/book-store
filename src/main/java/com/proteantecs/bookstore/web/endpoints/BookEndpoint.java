package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.services.BookService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class BookEndpoint extends ResourceRepositoryBase<Book,Long> {

    private final BookService bookService;

    public BookEndpoint(BookService bookService) {
        super(Book.class);
        this.bookService = bookService;
    }

    @PutMapping("update")
    public Book update(@RequestParam("id") Long id, @RequestParam String name, @RequestParam Double price,
                       @RequestParam String cover, @RequestParam String description) {
        return bookService.update(id, name, price, cover, description);
    }
//    public Book update(@RequestBody Book book) {
//        return bookService.update(book);
//    }

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

}
