package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.services.AuthorService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import org.springframework.stereotype.Component;


@Component
public class AuthorEndpoint extends ResourceRepositoryBase<Author, Long> {

    private final AuthorService authorService;

    public AuthorEndpoint(AuthorService authorService) {
        super(Author.class);
        this.authorService = authorService;
    }

    @Override
    public ResourceList<Author> findAll(QuerySpec querySpec) {
        var authors = authorService.findAll();
        var meta = new DefaultPagedMetaInformation();
        meta.setTotalResourceCount((long) authors.size());
        return new DefaultResourceList<>(authors, meta, new DefaultPagedLinksInformation());
    }

    @Override
    public Author save(Author author) {
        return authorService.save(author);
    }

    @Override
    public Author findOne(Long id, QuerySpec querySpec) {
        return authorService.findById(id);
    }

    @Override
    public void delete(Long id) {
        authorService.deleteById(id);
    }
}
