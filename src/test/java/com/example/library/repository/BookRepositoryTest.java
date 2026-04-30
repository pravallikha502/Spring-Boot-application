package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindAllWithAuthors() {
        // Given
        Author author = new Author("Query Author", "Test Bio");
        entityManager.persist(author);

        Book book = new Book("Query Book", "Test Genre", 15.0, author);
        entityManager.persist(book);
        entityManager.flush();

        // When
        List<Book> result = bookRepository.findAllWithAuthors();

        // Then
        assertFalse(result.isEmpty());
        assertEquals("Query Author", result.get(0).getAuthor().getName());
    }
}
