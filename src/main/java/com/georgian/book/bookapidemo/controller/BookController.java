package com.georgian.book.bookapidemo.controller;

import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.response.BookResponse;
import com.georgian.book.bookapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/books")
public class BookController {


    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody Book book){
        bookService.addNewBook(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(book.getBookId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public void updateBook(@RequestBody Book book,
                           @RequestParam(value =  "bookid")Long id){
        bookService.updateBookData(book,id);

    }

    @GetMapping()
    public List<Book> getAllBook(){
        List<Book> list=bookService.getAllBook();
        if(list.size()<=0){
            return (List<Book>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return list;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @GetMapping(path = "/books/{title}")
    public Book getBookByTitle(@PathVariable(value = "title") String title){
        return bookService.getBookByTitle(title);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBookById(@PathVariable(value ="id") Long id){
         bookService.deleteBookById(id);
    }


//
//    @GetMapping("/authors/{firstName}")
//    public List<Book> byAuthor(@PathVariable String firstName)
//    {
//        return bookRepository.findAllByAuthorFirstname(firstName);
//    }

//    @GetMapping("/")
//    public List<Book> retierevAllBooks(){
//        return bookService.getAllBook();
//    }

//    @GetMapping("/books/{id}")
//    public Optional<Book> retierevBookById(@PathVariable Long id){
//
//
//        return bookRepository.findById(id  );
//
//
//    }
//
//    @GetMapping("/books/{title}")
//    public Book retierevBook(@PathVariable String title){
//        return bookRepository.findBookByTitle(title);
//
//
//    }
//
//    @PostMapping("/books")
//    public ResponseEntity<Object> saveBook(@RequestBody Book book){
//        bookRepository.save(book);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/id}")
//                .buildAndExpand(book.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }



}
