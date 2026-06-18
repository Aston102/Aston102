package ru.aston.hometask2;

import java.util.List;

public class Student {

    private String name;
    private List<Book> books;

    public Student() {
    }

    public Student(String name, List<Book> books) {
        if (books == null || books.size() < 5) {
            throw new IllegalArgumentException(
                    "У студента должно быть минимум 5 книг"
            );
        }

        this.name = name;
        this.books = books;
    }


    public String getName() {
        return name;
    }


    public List<Book> getBooks() {
        return books;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}