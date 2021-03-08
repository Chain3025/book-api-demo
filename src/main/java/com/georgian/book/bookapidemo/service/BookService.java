package com.georgian.book.bookapidemo.service;


import com.georgian.book.bookapidemo.model.Author;
import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.respository.AuthorRepository;
import com.georgian.book.bookapidemo.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataLoader {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void loadData(){
        authorRepository.deleteAll();
        bookRepository.deleteAll();
        //create an author
        Author author = new Author(1L,"Chain","Singh");
        authorRepository.save(author);

        //create more author
        createAuthor();

        //create more posts
        createBooks(author);


    }
    private void createBooks(Author author){
        Book book  = new Book();
        book.setAuthor(author);
        book.setId(1000L);
        book.setTitle("spring-boot");
        bookRepository.save(book);
    }
    private void createAuthor() {
        Author jv = new Author(6L,"Pk","singh");
        authorRepository.save(jv);
        Author av = new Author(7L,"Dk","pandit");
        authorRepository.save(av);
        Author kv = new Author(8L,"Sk","kumar");
        authorRepository.save(kv);
    }

    public Book getBookbytitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public void createAuthorByWeb(Author author) {
        authorRepository.save(author);
    }
}
