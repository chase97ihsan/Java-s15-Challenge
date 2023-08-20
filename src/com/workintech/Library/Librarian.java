package com.workintech.Library;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Librarian extends Library {


    private String name;
    private Book book;

    public Librarian(TreeMap<Integer, Reader> readers, HashSet<Book> authors, TreeMap<Integer, Book> books) {
        super(readers, authors, books);
        this.name = "Dilara";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public TreeMap<Integer, Book> addBooks(int id, Book book) {
        if (!getBooks().containsKey(id)) {
            getBooks().put(id, book);
        } else {
            int newId=getBooks().size()+1;
            getBooks().put(newId, book);
        }
        return getBooks();
    }

    @Override
    public TreeMap<Integer, Book> deleteBooks(int id) {
        if(getBooks().containsKey(id)){
            getBooks().remove(id);
        }else{
            System.out.println("Please enter the correct id.");
        }
        return getBooks();
    }

    @Override
    public TreeMap<Integer, Book> updateTheBook(Book book1, Book book2) {
        if (getBooks().containsValue(book1)) {
            book1.setName(book2.getName());
            book1.setPrice(book2.getPrice());
        }
        return getBooks();
    }

    @Override
    public Book chooseBook(int id, Reader reader) {
        if (getBooks().containsKey(id) && getBooks().get(id).getStatus() == Status.AVAILABLE) {
            setBook(getBooks().get(id));
            chooseBook(reader,getBooks().get(id));

        }
        return book;
    }

    public Book chooseBook(String name, Reader reader) {
        for (Book value : getBooks().values()) {
            if (value.getName().equals(name) && value.getStatus() == Status.AVAILABLE) {
                setBook(value);
                chooseBook(reader,value);

            }
        }
        return book;
    }

    public Book chooseOneOfWorksAuthors(String name, Reader reader) {
        for (Book value : getBooks().values()) {
            if (value.getAuthor().getName().equals(name) && value.getStatus() == Status.AVAILABLE) {
                setBook(value);
                chooseBook(reader,value);
                break;
            }
        }
        return book;
    }

    public Book chooseBook(Reader reader,Book book1) {
        if (reader.getMyBooks().size() <= 5) {
            reader.borrowbook(this.book.getId(), this.book);
            reader.updateMyInvoiceFee(22.5);
            book1.updateStatus();
        }
        return this.book;
    }

    public TreeMap<Integer, Book> backTheBook(Reader reader, Book book) {
        reader.updateMyInvoiceFee(-22.5);
        reader.giveBackBook(book);
        for (Book value : getBooks().values()) {
            if (value == book) {
                value.updateStatus();
            }
        }
        return getBooks();
    }

    @Override
    public HashSet<Book> authorAndWorks(String name) {
        getAuthors().clear();
        for (Book value : getBooks().values()) {
            if (value.getAuthor().getName().equals(name)) {
                getAuthors().add(value);
            }
        }
        return getAuthors();
    }

    @Override
    public TreeMap<Integer, Reader> saveReaders(int id, Reader reader) {
        if (!getReaders().containsKey(id)) {
            getReaders().put(id, reader);
        } else {
            while (getReaders().containsKey(id)) {
                id++;
                if (!getReaders().containsKey(id)) {
                    getReaders().put(id, reader);
                }
            }
        }
        return getReaders();
    }
}

