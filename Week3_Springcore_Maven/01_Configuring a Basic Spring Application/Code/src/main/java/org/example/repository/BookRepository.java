package org.example.repository;

public class BookRepository {

    public BookRepository(){
        System.out.println("Book Repository Created");
    }

    public void saveBook(String title) {
        System.out.println("Book saved: " + title);
    }
}

