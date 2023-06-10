package com.jb.bookandauthor.repos;

import com.jb.bookandauthor.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByYearBetween(int from,int until);
    @Query(value = "SELECT AVG(year) FROM books_targil2.books",nativeQuery = true)
    double getAvgYear();

    @Query(value = "SELECT AVG(year) FROM books_targil2.books WHERE author_id = :authorId", nativeQuery = true)
    double getAvgYearOfAuthor(@Param("authorId") int authorId);


}
