package com.workintech.Library;

import com.workintech.Library.Address;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Reader extends Person {

    private Address address;
    private int phoneNumber;
    private TreeMap<Integer, Book> myBooks;
    private double myInvoiceFee;

    public Reader(String name, int id, Address address, int phoneNumber, TreeMap<Integer, Book> myBooks) {
        super(name, id);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.myBooks = myBooks;
        this.myInvoiceFee = 0;
    }

    public TreeMap<Integer, Book> getMyBooks() {
        return myBooks;
    }

    public double getMyInvoiceFee() {
        return myInvoiceFee;
    }

    public double updateMyInvoiceFee(double fee) {
        this.myInvoiceFee += fee;
        return getMyInvoiceFee();
    }

    public TreeMap<Integer, Book> borrowbook(int id, Book book) {
        if (!myBooks.containsKey(id)) {
            getMyBooks().put(id, book);
        } else {
            int newId=getMyBooks().size()+1;
            getMyBooks().put(newId, book);
        }
        return getMyBooks();
    }

    public TreeMap<Integer, Book> giveBackBook(Book book) {
        if (getMyBooks().containsValue(book)) {
            getMyBooks().remove(book);
            updateMyInvoiceFee(-22.5);
        } else {
            getMyBooks().remove(myBooks.firstKey());
        }
        return getMyBooks();
    }

    @Override
    public String toString() {
        return "Reader{" +
                 address +
                ", phoneNumber=" + phoneNumber +
                ", myBooks=" + myBooks +
                ", myInvoiceFee=" + myInvoiceFee +
                '}';
    }
}
