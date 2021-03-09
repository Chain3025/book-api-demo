package com.georgian.book.bookapidemo.controller;

import com.georgian.book.bookapidemo.model.Author;
import com.georgian.book.bookapidemo.respository.AuthorRepository;
import com.georgian.book.bookapidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {


//
//    @Autowired
//    private AuthorRepository authorRepository;
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping("/authors")
//    public List<Author> retierevAllAuthor(){
//        return authorRepository.findAll();
//    }
//
//    @GetMapping("/authors/{id}")
//    public Optional<Author> retierevAuthorById(@PathVariable Long id){
//        return authorRepository.findById(id  );
//
//
//    }
//
//    @DeleteMapping("/authors/{id}")
//    public void deleteAuthorById(@PathVariable Long id){
//        //return authorRepository.findById(id  );
//        authorRepository.deleteById(id);
//
//    }
//    @PostMapping("/authors")
//    public ResponseEntity<Object> saveAuthor(@RequestBody Author author){
//        //authorRepository.save(author);
//        bookService.createAuthorByWeb(author);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/id}")
//                .buildAndExpand(author.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
}
