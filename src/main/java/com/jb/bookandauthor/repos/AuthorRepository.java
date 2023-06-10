package com.jb.bookandauthor.repos;

import com.jb.bookandauthor.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Integer> {
}
