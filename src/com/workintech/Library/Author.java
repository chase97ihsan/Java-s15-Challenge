package com.workintech.Library;

import java.util.ArrayList;
import java.util.HashSet;

public class Author extends Person {

   private HashSet<Book> books;

    public Author(String name, int id) {
        super(name, id);
        this.books = books;
    }

    public void books(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return getName();
    }


}
