package com.workintech.Library;

import java.util.HashSet;
import java.util.TreeMap;

public abstract class Library {

    private TreeMap<Integer,Reader> readers;
    private TreeMap<Integer,Author> authors;
    private  TreeMap<Integer,Book> books;

    public Library(TreeMap<Integer, Reader> readers, TreeMap<Integer, Author> authors, TreeMap<Integer, Book> books) {
        this.readers = readers;
        this.authors = authors;
        this.books = books;
    }

    public TreeMap<Integer, Reader> getReaders() {
        return readers;
    }

    public TreeMap<Integer, Author> getAuthors() {
        return authors;
    }


    public TreeMap<Integer, Book> getBooks() {
        return books;
    }

    public abstract TreeMap<Integer, Book>   addBooks(int id,Book book);
    public abstract TreeMap<Integer, Book>  deleteBooks(int id);
    public abstract Book  chooseBook(int id);
    public abstract Book  chooseBook(String name);
    public abstract Book  chooseBook(Author author);
    public abstract Book  chooseBook(Reader reader);



}
