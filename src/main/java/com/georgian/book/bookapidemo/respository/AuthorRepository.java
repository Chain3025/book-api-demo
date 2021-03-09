package com.georgian.book.bookapidemo.respository;

import com.georgian.book.bookapidemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}
