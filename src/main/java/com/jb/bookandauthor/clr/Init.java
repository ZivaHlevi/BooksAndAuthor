package com.jb.bookandauthor.clr;

import com.jb.bookandauthor.beans.Author;
import com.jb.bookandauthor.beans.Book;

import com.jb.bookandauthor.repos.AuthorRepository;
import com.jb.bookandauthor.repos.BookRepository;
import com.jb.bookandauthor.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = Book.builder().name("Book1").year(1970).build();
        Book b2 = Book.builder().name("Book2").year(1658).build();
        Book b3 = Book.builder().name("Book3").year(2000).build();
        Book b4 = Book.builder().name("Book4").year(1650).build();
        Book b5 = Book.builder().name("Book5").year(1970).build();
        Book b6 = Book.builder().name("Book6").year(1658).build();
        Book b7 = Book.builder().name("Book7").year(2000).build();
        Book b8 = Book.builder().name("Book8").year(1650).build();

        Author a1 = Author.builder().name("Author1").books(List.of(b1, b2)).build();
        Author a2 = Author.builder().name("Author2").books(List.of(b3, b4)).build();
        Author a3 = Author.builder().name("Author3").books(List.of(b5, b6)).build();
        Author a4 = Author.builder().name("Author4").books(List.of(b7, b8)).build();
        //1.work ok
//        authorRepository.save(a1);
//        authorRepository.save(a2);
//        authorRepository.saveAll(List.of(a3,a4));
        //2.Add - work o.k
        libraryService.addAuthor(a1);
        libraryService.addAuthor(a2);
        libraryService.addAuthor(a3);
        libraryService.addAuthor(a4);

        //3.Delete-ok
        try {
            libraryService.deleteAuthor(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            libraryService.deleteAuthor(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        libraryService.addAuthor(a2);
        //4.All Books-ok
        System.out.println("All books: ");
        libraryService.getAllBooks().forEach(System.out::println);
        //5.Get single author
        System.out.println("Get single author #1");
        try {
            System.out.println(libraryService.getAuthor(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get single author #10");
        try {
            System.out.println(libraryService.getAuthor(10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //6.Get books between years
        System.out.println("Get books between years 1400 1850");
        try {
            libraryService.getBooksBetweenYears(1400,1850).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get books between years1850 1400");
        try {
            libraryService.getBooksBetweenYears(1850,1400).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get books between -25 1400");
        try {
            libraryService.getBooksBetweenYears(-25,1400).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //7.Avg Year
        System.out.println(libraryService.getAvgYear());
        //8.Avg Year of Author #1
        System.out.println(libraryService.getAvgYearOfAuthor(1));

        Author a5= Author.builder().name("Author5").books(null).build();
        libraryService.addAuthor(a5);
        try {
            System.out.println(libraryService.getAvgYearOfAuthor(6));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



}
