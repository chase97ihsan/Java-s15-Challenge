package com.workintech.Library;

import com.workintech.Library.Address;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Reader extends Person {

    private Address address;
    private int phoneNumber;
    private LinkedHashMap<Integer,Book> myBooks;

    public Reader(String name, long id, Address address, int phoneNumber) {
        super(name, id);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public LinkedHashMap<Integer, Book> getMyBooks() {
        return myBooks;
    }

    public LinkedHashMap<Integer,Book> borrowbook(Book book){
        getMyBooks().put(book.getId(),book);
        return getMyBooks();
    }


}
