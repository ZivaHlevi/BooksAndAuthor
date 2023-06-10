package com.jb.bookandauthor.service;


import com.jb.bookandauthor.beans.Author;
import com.jb.bookandauthor.beans.Book;
import com.jb.bookandauthor.exseptions.LibraryCustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibraryService {

    void addAuthor(Author author);
    void deleteAuthor(int authorId) throws LibraryCustomException;
    List<Book> getAllBooks();
    Optional<Author> getAuthor(int authorId) throws LibraryCustomException;
    List<Book> getBooksBetweenYears(int from,int until) throws LibraryCustomException;
    double getAvgYear();
    double getAvgYearOfAuthor(int authorId) throws LibraryCustomException;


}
