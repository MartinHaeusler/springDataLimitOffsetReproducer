package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class BookServiceTest {

    @Autowired
    private BookService bookService;



    @Test
    void canGetBooksBySpecification() {
        this.bookService.saveBook(new Book("Book 1", 10));
        this.bookService.saveBook(new Book("Book 2", 100));
        this.bookService.saveBook(new Book("Book 3", 20));
        this.bookService.saveBook(new Book("Book 4", 1256));

        List<Book> result = this.bookService.findBooksByPagesDesc(new BookNameContainsSpec("ook"), 100, 0);
        Assertions.assertEquals(4, result.size(), "Expected exactly 4 books in the result.");
        Assertions.assertEquals("Book 4", result.get(0).getName());
        Assertions.assertEquals("Book 2", result.get(1).getName());
        Assertions.assertEquals("Book 3", result.get(2).getName());
        Assertions.assertEquals("Book 1", result.get(3).getName());
    }

    @Test
    void canGetBooksBySpecificationWithLimit() {
        this.bookService.saveBook(new Book("Book 1", 10));
        this.bookService.saveBook(new Book("Book 2", 100));
        this.bookService.saveBook(new Book("Book 3", 20));
        this.bookService.saveBook(new Book("Book 4", 1256));

        List<Book> result = this.bookService.findBooksByPagesDesc(new BookNameContainsSpec("ook"), 2, 0);
        Assertions.assertEquals(2, result.size(), "Expected exactly 2 books in the result.");
        Assertions.assertEquals("Book 4", result.get(0).getName());
        Assertions.assertEquals("Book 2", result.get(1).getName());
    }


}
