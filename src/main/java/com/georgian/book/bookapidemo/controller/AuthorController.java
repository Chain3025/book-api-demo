package com.georgian.book.bookapidemo.controller;

import com.georgian.book.bookapidemo.model.Author;
import com.georgian.book.bookapidemo.respository.AuthorRepository;
import com.georgian.book.bookapidemo.service.AuthorService;
import com.georgian.book.bookapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {



    @Autowired
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService, BookService bookService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/authors")
    public void createAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/id}")
//                .buildAndExpand(author.getId())
//                .toUri();

    }
    @PutMapping("/authors")
    public void updateAuthor(@RequestBody Author author,@RequestParam(value = "id")Long id){
        authorService.updateauthor(author,id);
    }
    @GetMapping("/authors")
    public List<Author> retierevAllAuthor(){
        return authorService.retierveAllAuthors();
    }
    @GetMapping(path="/authors/name/{firstName}")
    public List<Author> retierevAuthorByName(@PathVariable String firstName){
        return authorService.retierveAuthorByName(firstName);
    }
    @GetMapping(path="/authors/name/last/{lastName}")
    public List<Author> retierevAuthorByLastName(@PathVariable String lastName){
        return authorService.retierveAuthorByLastName(lastName);
    }

    @GetMapping("/authors/{id}")
    public Author retierveAuthorById(@PathVariable Long id){
        return authorService.retierveAuthorById(id);


    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthorById(@PathVariable Long id){
        //return authorRepository.findById(id  );
        authorRepository.deleteById(id);

    }

}
