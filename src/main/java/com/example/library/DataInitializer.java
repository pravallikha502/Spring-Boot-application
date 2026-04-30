package com.example.library;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create 10 Authors
        List<Author> authors = Arrays.asList(
            new Author("J.K. Rowling", "British author, best known for Harry Potter."),
            new Author("George R.R. Martin", "American novelist, writer of A Song of Ice and Fire."),
            new Author("J.R.R. Tolkien", "English writer, philologist, and academic."),
            new Author("Agatha Christie", "English writer known for her 66 detective novels."),
            new Author("Stephen King", "American author of horror and supernatural fiction."),
            new Author("Ernest Hemingway", "American novelist and short-story writer."),
            new Author("Mark Twain", "American writer, humorist, entrepreneur."),
            new Author("Fyodor Dostoevsky", "Russian novelist, short story writer, essayist."),
            new Author("Jane Austen", "English novelist known for her six major novels."),
            new Author("Leo Tolstoy", "Russian writer who is regarded as one of the greatest authors.")
        );
        authorRepository.saveAll(authors);

        // Create 10 Books
        List<Book> books = Arrays.asList(
            new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 25.0, authors.get(0)),
            new Book("A Game of Thrones", "Fantasy", 30.0, authors.get(1)),
            new Book("The Hobbit", "Fantasy", 20.0, authors.get(2)),
            new Book("Murder on the Orient Express", "Mystery", 15.0, authors.get(3)),
            new Book("The Shining", "Horror", 22.0, authors.get(4)),
            new Book("The Old Man and the Sea", "Literary Fiction", 12.0, authors.get(5)),
            new Book("The Adventures of Tom Sawyer", "Adventure", 18.0, authors.get(6)),
            new Book("Crime and Punishment", "Psychological Fiction", 20.0, authors.get(7)),
            new Book("Pride and Prejudice", "Romance", 14.0, authors.get(8)),
            new Book("War and Peace", "Historical Fiction", 35.0, authors.get(9))
        );
        bookRepository.saveAll(books);
    }
}
