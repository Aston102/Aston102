package ru.aston.hometask2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите путь к JSON-файлу: ");

            StudentService.findBookYear(
                    StudentService.readStudents(scanner.nextLine())
            ).ifPresentOrElse(
                    year -> System.out.println("Год выпуска книги: " + year),
                    () -> System.out.println("Такая книга отсутствует")
            );
        }
    }
}