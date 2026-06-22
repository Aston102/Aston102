import ru.aston.hometask2.Student;
import ru.aston.hometask2.StudentService;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldReadStudentsFromJson() throws Exception {
        List<Student> students = StudentService.readStudents(
                "src/main/resources/students.json"
        );

        assertAll(
                () -> assertEquals(2, students.size()),
                () -> assertTrue(
                        students.stream()
                                .allMatch(student -> student.getBooks().size() >= 5)
                )
        );
    }

    @Test
    void shouldReturnFirstBookYearAfterStreamProcessing() throws Exception {
        assertEquals(
                Optional.of(2006),
                StudentService.findBookYear(
                        StudentService.readStudents(
                                "src/main/resources/students.json"
                        )
                )
        );
    }
}