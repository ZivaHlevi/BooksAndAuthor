package com.jb.bookandauthor.controller;

import com.jb.bookandauthor.beans.Author;
import com.jb.bookandauthor.beans.Book;
import com.jb.bookandauthor.service.LibraryService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/library")
public class LibertyController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping//("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @SneakyThrows
    @GetMapping("/{authorId}")
    public Optional<Author> getAuthor(@PathVariable int authorId) {
        return libraryService.getAuthor(authorId);
    }

    @SneakyThrows
    @GetMapping("/{from}/{until}")
    public List<Book> getBooksBetweenYears(@PathVariable int from, @PathVariable int until) {
        return libraryService.getBooksBetweenYears(from, until);
    }
    /*If you want to use @RequestParam instead of @PathVariable*/
    @SneakyThrows
    @GetMapping("/books") ///books?from=2000&until=2020
    public List<Book> getBooksBetweenYear(@RequestParam("from") int from, @RequestParam("until") int until) {
    return libraryService.getBooksBetweenYears(from, until);
}
    // */

    @SneakyThrows
    @GetMapping("/avg/{authorId}")
    public double getAvgYearOfAuthor(@PathVariable int authorId) {
        return libraryService.getAvgYearOfAuthor(authorId);
    }
    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        libraryService.addAuthor(author);
    }
    @SneakyThrows
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable int authorId) {
        libraryService.deleteAuthor(authorId);
    }

}
