package com.georgian.book.bookapidemo.controller;

import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.response.BookResponse;
import com.georgian.book.bookapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/book")
public class BookController {


    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@RequestBody Book book){
        bookService.addNewBook(book);

    }

    @PutMapping
    public void updateBook(@RequestBody Book book,
                           @RequestParam(value =  "id")Long id){
        bookService.updateBookData(book,id);

    }

    @GetMapping()
    public List<BookResponse> getAllBook(){

       return bookService.getAllBooks();
    }
//
//    @GetMapping("/authors/{firstName}")
//    public List<Book> byAuthor(@PathVariable String firstName)
//    {
//        return bookRepository.findAllByAuthorFirstname(firstName);
//    }

    @GetMapping("/books")
    public List<Book> retierevAllBooks(){
        return bookService.getAllBook();
    }

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
