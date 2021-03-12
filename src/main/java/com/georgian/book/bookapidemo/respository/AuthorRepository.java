package com.georgian.book.bookapidemo.respository;

import com.georgian.book.bookapidemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {


    List<Author> findAllByFirstName(String name);

    List<Author> findAllByLastName(String name);
}
