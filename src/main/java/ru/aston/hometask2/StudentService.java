package ru.aston.hometask2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class StudentService {

    private StudentService() {
    }

    public static List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ObjectMapper().readValue(
                new File(filePath),
                new TypeReference<>() {
                }
        );

        for (Student student : students) {
            if (student.getBooks() == null || student.getBooks().size() < 5) {
                throw new IllegalArgumentException(
                        "У каждого студента должно быть минимум 5 книг"
                );
            }
        }

        return students;
    }

    public static Optional<Integer> findBookYear(List<Student> students) {
        return students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst();
    }
}
