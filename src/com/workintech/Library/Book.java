package com.workintech.Library;

import java.util.Objects;

public class Book {

    private Status status;
    private int price;
    private int edition;
    private Author author;
    private String name;
    private int id;

    public Book(Status status, int price, int edition, Author author, String name, int id) {
        this.status = status;
        this.price = price;
        this.edition = edition;
        this.author = author;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void updateStatus() {
        if (this.status == Status.AVAILABLE) {
            this.status = Status.NOT_AVAILABLE;
        } else {
            this.status = Status.AVAILABLE;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Book:" + name + "\n");
        stringBuilder.append("Author:" + author.getName() + "\n");
        stringBuilder.append("Id:" + id + "\n");
        stringBuilder.append("Statu:" + status + "\n");
        stringBuilder.append("Edition:" + edition + "\n");
        stringBuilder.append("Price:" + price + "\n"+"\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
