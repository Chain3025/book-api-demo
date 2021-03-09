package com.georgian.book.bookapidemo.model;


import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    private Integer bookPages;
    private Long authorId;

    public Book() {
    }

    public Book(String bookTitle, Integer bookPages, Long authorId) {
        this.bookTitle = bookTitle;
        this.bookPages = bookPages;
        this.authorId = authorId;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookPages=" + bookPages +
                ", authorId=" + authorId +
                '}';
    }


    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getBookPages() {
        return bookPages;
    }

    public void setBookPages(Integer bookPages) {
        this.bookPages = bookPages;
    }
}
