package com.workintech.Library;

import java.util.HashSet;
import java.util.TreeMap;

public class Librarian extends Library {


    private String name;
    private Book book;

    public Librarian(TreeMap<Integer, Reader> readers, TreeMap<Integer, Author> authors, TreeMap<Integer, Book> books) {
        super(readers, authors, books);
        this.name = "Dilara" ;
    }


    @Override
    public TreeMap<Integer, Book> addBooks(int id, Book book) {
        if (!getBooks().containsKey(id)) {
            getBooks().put(id, book);
        } else {
            while (getBooks().containsKey(id)) {
                id= id+1;
                if (!getBooks().containsKey(id)) {
                    getBooks().put(id, book);
                }
            }
        }
        return getBooks();
    }

    @Override
    public TreeMap<Integer, Book> deleteBooks(int id) {
        getBooks().remove(id);
        return getBooks();
    }

    @Override
    public Book chooseBook(int id) {
        if(getBooks().containsKey(id)){
            this.book=getBooks().get(id);
            getBooks().remove(id);
        }
        return book;
    }
    public Book chooseBook(Reader reader) {
        if(getBooks().containsKey(id)){
            this.book=getBooks().get(id);
            getBooks().remove(id);

        }
        return book;
    }

    @Override
    public Book chooseBook(String name) {
        return null;
    }

    @Override
    public Book chooseBook(Author author) {
        return null;
    }

    @Override
    public Book chooseBook(Reader reader) {

    }
}

