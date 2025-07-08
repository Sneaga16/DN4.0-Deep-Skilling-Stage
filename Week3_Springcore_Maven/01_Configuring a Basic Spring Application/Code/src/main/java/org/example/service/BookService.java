package org.example.service;

import org.example.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(){
        System.out.println("Book Service Created");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.saveBook(title);
    }
}

