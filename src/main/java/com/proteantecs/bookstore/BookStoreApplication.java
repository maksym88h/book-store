package com.proteantecs.bookstore;

import com.proteantecs.bookstore.config.CrnkConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookStoreApplication.class, args);
    }

}
