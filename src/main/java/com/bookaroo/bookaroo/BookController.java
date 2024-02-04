package com.bookaroo.bookaroo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookaroo")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.findBooksByGenre(genre);
    }


    @PostMapping("/create/{id}")
    public void addBook(@RequestBody Book book) {

    }

    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book) {

    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable String id) {

    }
}
