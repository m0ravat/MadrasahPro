package com.mosque.management.education;

public class Book {
    private String bookName;
    private String bookDesc;
    private String author;
    private double price;
    private Subject subject;
    public Book(String bookName, String bookDesc, String author, double price,
                Subject subject) {
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.author = author;
        this.price = price;
        this.subject = subject;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
