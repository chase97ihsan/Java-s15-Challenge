package com.workintech.Library;

import java.util.HashSet;
import java.util.TreeMap;

public abstract class Library {

    private TreeMap<Integer, Reader> readers;
    private HashSet<Book> authors;
    private TreeMap<Integer, Book> books;

    public Library(TreeMap<Integer, Reader> readers,  HashSet<Book> authors, TreeMap<Integer, Book> books) {
        this.readers = readers;
        this.authors = authors;
        this.books = books;
    }

    public TreeMap<Integer, Reader> getReaders() {
        return readers;
    }

    public  HashSet<Book> getAuthors() {
        return authors;
    }



    public TreeMap<Integer, Book> getBooks() {
        return books;
    }

    public abstract TreeMap<Integer, Book> addBooks(int id, Book book);

    public abstract TreeMap<Integer, Book> deleteBooks(int id);

    public abstract Book chooseBook(int id, Reader reader);
    public abstract   HashSet<Book> authorAndWorks(String name);
    public abstract  TreeMap<Integer, Book>  updateTheBook(Book book1,Book book2);
    public abstract TreeMap<Integer, Reader>  saveReaders(int id,Reader reader);


}
