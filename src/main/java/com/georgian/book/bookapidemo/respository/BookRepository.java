package com.georgian.book.bookapidemo.respository;

import com.georgian.book.bookapidemo.model.Author;
import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.response.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



    @Query(value =
            "SELECT b.book_id AS book_id, b.book_title AS title, b.book_pages As book_pages" +
                    " ,a.first_name AS author_firstname, a.last_name As author_lastname " +
                    "FROM book b JOIN author a ON b.author_id = a.author_id;", nativeQuery = true)
    List<BookResponse> findAllBooks();

    Optional<Book> findByBookTitle(String title);
}
