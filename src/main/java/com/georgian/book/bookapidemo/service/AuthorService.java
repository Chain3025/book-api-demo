package com.georgian.book.bookapidemo.service;

import com.georgian.book.bookapidemo.model.Author;
import com.georgian.book.bookapidemo.respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> retierveAllAuthors() {
        return authorRepository.findAll();
    }

    public Author retierveAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(!author.isPresent()){
            return null;
        }
        Author author1 = author.get();
        return author1;
    }

    public List<Author> retierveAuthorByName(String name) {
        return authorRepository.findAllByFirstName(name);
    }

    public List<Author> retierveAuthorByLastName(String name) {
        return authorRepository.findAllByLastName(name);
    }



    public void updateauthor(Author author, Long id) {

        Optional<Author> byId = authorRepository.findById(id);
        if(!byId.isPresent()){
            return ;
        }
        Author author1 = byId.get();
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        authorRepository.save(author1);
    }
}
