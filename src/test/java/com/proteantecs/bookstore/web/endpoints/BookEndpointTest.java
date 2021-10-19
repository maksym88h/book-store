package com.proteantecs.bookstore.web.endpoints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BookEndpointTest extends BaseCrnkEndpointTest {

    @BeforeEach
    public void initAbClass() throws IOException {
        init(
                "/api/books/",
              "book-create-json-api.json",
              "book-patch-json-api.json"
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
    void create() throws IOException {
        createObject();
    }

    @Test
    void delete() {
        deleteObject();
    }
}