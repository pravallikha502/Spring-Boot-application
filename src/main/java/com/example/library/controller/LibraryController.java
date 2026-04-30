package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = libraryService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book, @RequestParam("authorId") Long authorId) {
        Author author = libraryService.getAuthorById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        libraryService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = libraryService.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", book);
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, @RequestParam("authorId") Long authorId) {
        Author author = libraryService.getAuthorById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setId(id);
        book.setAuthor(author);
        libraryService.saveBook(book);
        return "redirect:/books";
    }
}
