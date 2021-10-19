package com.proteantecs.bookstore.config;


import com.proteantecs.bookstore.domain.Author;
import com.proteantecs.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CrnkConfig {
    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void setup() {
        authorRepository.save(new Author());

    }

}
