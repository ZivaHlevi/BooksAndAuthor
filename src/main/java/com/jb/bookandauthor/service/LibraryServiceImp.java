package com.jb.bookandauthor.service;

import com.jb.bookandauthor.beans.Author;
import com.jb.bookandauthor.beans.Book;
import com.jb.bookandauthor.exceptions.LibraryCustomException;
import com.jb.bookandauthor.exceptions.MsgExp;
import com.jb.bookandauthor.repos.AuthorRepository;
import com.jb.bookandauthor.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImp implements LibraryService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int authorId) throws LibraryCustomException {
        if (!authorRepository.existsById(authorId)) {
            throw new LibraryCustomException(MsgExp.ID_AUTHOR_FAILED);
        }
        authorRepository.deleteById(authorId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthor(int authorId) throws LibraryCustomException {
        if (!authorRepository.existsById(authorId)) {
            throw new LibraryCustomException(MsgExp.ID_AUTHOR_FAILED);
        }
        return authorRepository.findById(authorId);
    }

    @Override
    public List<Book> getBooksBetweenYears(int from, int until) throws LibraryCustomException {
        if (from <= 0 || until <= 0) {
            throw new LibraryCustomException(MsgExp.YEAR_FAIL);
        }
        if (from > until) {
            return bookRepository.findByYearBetween(until, from);
        }
        return bookRepository.findByYearBetween(from, until);
    }

    @Override
    public double getAvgYear() {
       return bookRepository.getAvgYear();
    }

    @Override
    public double getAvgYearOfAuthor(int authorId) throws LibraryCustomException {
        if (!authorRepository.existsById(authorId)) {
            throw new LibraryCustomException(MsgExp.ID_AUTHOR_FAILED);
        }
        if (authorRepository.getReferenceById(authorId).getBooks().isEmpty()) {
            throw new LibraryCustomException(MsgExp.NO_BOOKS);
        }
        return bookRepository.getAvgYearOfAuthor(authorId);
    }
}
