package com.georgian.book.bookapidemo.controller;

import com.georgian.book.bookapidemo.model.Book;
import com.georgian.book.bookapidemo.response.BookResponse;
import com.georgian.book.bookapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void createBook(@RequestBody Book book){
        bookService.addNewBook(book);

    }

    @PutMapping
    public void updateBook(@RequestBody Book book,
                           @RequestParam(value =  "bookid")Long id){
        bookService.updateBookData(book,id);

    }

    @GetMapping()
    public List<BookResponse> getAllBook(){

       return bookService.getAllBooks();
    }

    @GetMapping(path = "/bookById")
    public Optional<Book> getBookById(@RequestParam(value =  "bookid")Long id){
        return bookService.getBookById(id);
    }

    @GetMapping(path = "/bookByTitle")
    public Optional<Book> getBookByTitle(@RequestParam(value = "booktitle") String title){
        return bookService.getBookByTitle(title);
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam(value ="bookid") Long id){
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
