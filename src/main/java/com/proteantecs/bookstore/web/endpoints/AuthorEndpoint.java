package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.services.AuthorService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorEndpoint extends ResourceRepositoryBase<Author,Long> {

    private final AuthorService authorService;
    public AuthorEndpoint(AuthorService authorService) {
        super(Author.class);
        this.authorService = authorService;
    }

    @Override
    public ResourceList<Author> findAll(QuerySpec querySpec) {
        return querySpec.apply(authorService.findAll());
    }

    @Override
    public Class<Author> getResourceClass() {
        return Author.class;
    }

    @Override
    public Author findOne(Long id, QuerySpec querySpec) {
        return authorService.findOne(id);
    }

    @Override
    public <S extends Author> S save(S resource) {
        return (S) authorService.save(resource.getId(), resource);
    }

    @Override
    public <S extends Author> S create(S resource) {
        return (S) authorService.create(resource);
    }

    @Override
    public void delete(Long id) {
        authorService.delete(id);
    }

    @GetMapping("/findAuthorByName")
    public Author findByName(@RequestBody Author author) {
        Author newAuthor = authorService.findOneByName(author.getLastName());
        return newAuthor;
    }
}
