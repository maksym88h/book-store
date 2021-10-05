package com.proteantecs.bookstore.services;

import com.proteantecs.bookstore.domain.Book;
import com.proteantecs.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookService;

    @Test
    void save() {
        Book book = mock(Book.class);
        Book saveBook = mock(Book.class);

        when(bookRepository.save(book)).thenReturn(saveBook);

        Book save = bookService.save(book);
        assertThat(book).isEqualTo(save);
    }

    @Test
    void findAll() {
        List<Book> books = List.of(mock(Book.class));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> bookList = bookService.findAll();
        assertThat(books).isEqualTo(bookList);

    }

    @Test
    void deleteById() {
//
//        Book book = mock(Book.class);
//        Book deletedBook = mock(Book.class);
//
//        when(bookRepository.deleteById()).thenReturn(deletedBook);

    }
}