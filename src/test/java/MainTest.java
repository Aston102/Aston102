import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.aston.hometask2.Book;
import ru.aston.hometask2.Student;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldReadStudentsFromJson() throws Exception {
        List<Student> students = new ObjectMapper().readValue(
                new File("src/main/resources/students.json"),
                new TypeReference<>() {}
        );
        assertEquals(2, students.size());
        assertTrue(students.stream().allMatch(student -> student.getBooks().size() >= 5));
    }

    @Test
    void shouldReturnFirstBookYearAfterStreamProcessing() throws Exception {
        assertEquals(
                Optional.of(2006),
                new ObjectMapper().readValue(
                                new File("src/main/resources/students.json"),
                                new TypeReference<List<Student>>() {}
                        )
                        .stream()
                        .flatMap(student -> student.getBooks().stream())
                        .sorted(Comparator.comparingInt(Book::getPages))
                        .distinct()
                        .filter(book -> book.getYear() > 2000)
                        .limit(3)
                        .map(Book::getYear)
                        .findFirst()
        );
    }
}