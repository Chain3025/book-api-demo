package com.georgian.book.bookapidemo.service;


import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.response.BookResponse;
import com.georgian.book.bookapidemo.respository.AuthorRepository;
import com.georgian.book.bookapidemo.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


//    public Book getBookbytitle(String title){
//        return bookRepository.findBookByTitle(title);
//    }
//
//    public void createAuthorByWeb(Author author) {
//        authorRepository.save(author);
//    }



    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBookData(Book bookRequest, Long id) {

        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()) {
            return;
        }
        Book book = bookOptional.get();
        if(bookRequest.getBookTitle() != null){
            book.setBookTitle(bookRequest.getBookTitle()); ;
        }

        if(bookRequest.getBookPages() != null){
            book.setBookPages(bookRequest.getBookPages());
        }
        if(bookRequest.getAuthorId() != null){
            book.setAuthorId(bookRequest.getAuthorId()); ;
        }
        bookRepository.save(book);




    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.get();
    }

    public Book getBookByTitle(String title) {
        Optional<Book> byBookTitle = bookRepository.findByBookTitle(title);
        return byBookTitle.get();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
