package com.proteantecs.bookstore.web.endpoints;

import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.services.AuthorService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.links.DefaultPagedLinksInformation;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.core.resource.meta.DefaultPagedMetaInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

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
        List<Author> authors = authorService.findAll();
        DefaultPagedMetaInformation metaInformation = new DefaultPagedMetaInformation();
        metaInformation.setTotalResourceCount((long) authors.size());
        return new DefaultResourceList<>(authors,metaInformation,new DefaultPagedLinksInformation());
    }

    @Override
    public <S extends Author> S create(S resource) {
        return (S) authorService.save(resource);
    }

    @Override
    public void delete(Long id) {
        authorService.deleteById(id);
    }

    @GetMapping("/findAuthorByName")
    public Author findByName(@RequestBody Author author) {
        Author newAuthor = authorService.findByName(author.getFirstName());
        return newAuthor;
    }
}
