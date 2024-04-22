package exceptions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class SubjectTest {

    @Test
    public void testSuccessfulExecution() {
        University university = new University("BSTU");
        Faculty faculty = new Faculty("FIT");
        university.addFaculty(faculty);
        Group group = new Group("3-2");
        faculty.addGroup(group);
        Student student = new Student("Maksim");
        student.addSubject(new Subject("Math", 8));
        group.addStudent(student);
        double averageMark = university.calculateAverageMarkForSubject("Math");
        assertEquals(8.0, averageMark, 0.001);
    }
}
