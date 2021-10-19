package com.proteantecs.bookstore.web.endpoints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AuthorEndpointTest extends BaseCrnkEndpointTest {

    @BeforeEach
    public void initAbstractClass() throws IOException {
        init(
                "/api/authors/",
                "author-create-json-api.json",
                "author-patch-json-api.json"
        );
    }

    @Test
    void findAll() throws IOException {
        findAllObject();
    }

    @Test
    void findOne() throws IOException {
        findOneObject();
    }

    @Test
    void save() throws IOException {
        saveObject();
    }

    @Test
    public void create() throws IOException {
        createObject();
    }

    @Test
    public void delete() {
        deleteObject();
    }

}