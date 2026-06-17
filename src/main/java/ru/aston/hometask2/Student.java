package src.main.java.ru.aston.hometask2;

public class Student {
    private String name;
    private List<Student> books;

    public Student(List<Student> books, String name) {
        if (books == null || books.size() < 5) {
            throw new IllegalArgumentException(
            );
        }
        this.books = books;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getBooks() {
        return books;
    }

    public void setBooks(List<Student> books) {
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
