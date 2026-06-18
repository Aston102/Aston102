package ru.aston.hometask2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ObjectMapper().readValue(
                new File("src/main/resources/students.json"),
                new TypeReference<List<Student>>() {
                }
        );

        students.forEach(student -> {
            if (student.getBooks() == null || student.getBooks().size() < 5) {
                throw new IllegalArgumentException(
                        "У студента " + student.getName()
                                + " должно быть минимум 5 книг"
                );
            }
        });

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}