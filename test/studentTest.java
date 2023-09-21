import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javaapplication53.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class studentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(System.out);
    }
// works
    @Test
    public void testSaveStudent() {
        // Prepare input data for the test
        String input = "123\nJohn\n18\njohn@example.com\nMath\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        student studentInstance = new student();
        studentInstance.saveStudent();

        ArrayList<String> studentList = studentInstance.getStudentList();
        assertTrue(studentList.size() > 0);
        String lastAddedStudent = studentList.get(studentList.size() - 1);
        assertTrue(lastAddedStudent.contains("ID: 123"));
        assertTrue(lastAddedStudent.contains("Name: John"));
        assertTrue(lastAddedStudent.contains("Age: 18"));
        assertTrue(lastAddedStudent.contains("E-mail: john@example.com"));
        assertTrue(lastAddedStudent.contains("Course: Math"));
    }

@Test
public void testSearchStudent() {
    // Create a new instance of the class containing the searchStudent() method
    student className = new student();

    // Set up the studentList with some sample data
    List<String> studentList = new ArrayList<>();
    studentList.add("ID: 1\nName: John Doe\nAge: 20\nE-mail: john@exple.com\nMat\n");
    studentList.add("ID: 2\nName: Jane Smith\nAge: 22\nE-mail: john@examle.com\nMah\n");
    studentList.add("ID: 3\nName: Michael Johnson\nAge: 21\nE-mail: jon@example.com\nath\n");

    // Set up the input for the searchStudent() method
    ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
    System.setIn(in);

    // Set up the output stream to capture the output of the searchStudent() method
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // Call the searchStudent() method
    className.searchStudent();

    // Verify the output of the searchStudent() method
    String expectedOutput = "-----------------------------------------------\n" +
                            "Student found:\n" +
                            "ID: 2\n" +
                            "Name: Jane Smith\n" +
                            "Age: 22\n" +
                            "-----------------------------------------------\n";
    assertEquals(expectedOutput, out.toString());
}


@Test
public void testDeleteStudent() {
    student st = new student();
    
    student studentInstance = new student();
    ArrayList<String> studentList = studentInstance.getStudentList();
    studentList.add("ID: 111\nName: Ca1ol\nAge: 19\nE-mail: carol@e12xample.com\nCourse: Physics1");

    // Create a new Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Provide input for the scanner
    ByteArrayInputStream in = new ByteArrayInputStream("111\nY\n".getBytes());
    System.setIn(in);

    // Set the studentList in the StudentManagement object
    st.setStudentList(studentList);

    // Prompt the user to enter the student ID
    System.out.print("Enter student ID to delete: ");
    String studentId = scanner.nextLine();

    // Prompt the user to confirm the deletion
    System.out.print("Are you sure you want to delete this student? (Y/N): ");
    String confirmation = scanner.nextLine();

    // Call the deleteStudent() method with the user input
    st.deleteStudent(studentId, confirmation);

    // Assert that the student was deleted and the appropriate message was printed
    assertEquals("Student deleted successfully.\n", outContent.toString());
}


    @Test
    public void testDeleteStudentStudentNotFound() {
        
        student st = new student();
        
        student studentInstance = new student();
        ArrayList<String> studentList = studentInstance.getStudentList();
        studentList.add("ID: 111\nName: Ca1ol\nAge: 19\nE-mail: carol@e12xample.com\nCourse: Physics1");
        studentList.add("ID: 112\nName: Ca2ol\nAge: 19\nE-mail: carol@exa1mple.com\nCourse: Physics2");
        studentList.add("ID: 113\nName: Car3ol\nAge: 19\nE-mail: carol@exa32mple.com\nCourse: Physic3s");

        // Provide input for the scanner
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);

        // Set the studentList in the StudentManagement object
        st.setStudentList((ArrayList<String>) studentList);

        st.deleteStudent();

        // Assert that the student was not found and the appropriate message was printed
        assertEquals("Enter student ID to delete: \n" +
                "-----------------------------------------------\n" +
                "Student not found.\n" +
                "-----------------------------------------------\n", outContent.toString());
    }

    
    @Test
    public void testDeleteStudentDeletionCancelled() {
        
        student st = new student();
        
        student studentInstance = new student();
        ArrayList<String> studentList = studentInstance.getStudentList();
        studentList.add("ID: 111\nName: Ca1ol\nAge: 19\nE-mail: carol@e12xample.com\nCourse: Physics1");
        studentList.add("ID: 112\nName: Ca2ol\nAge: 19\nE-mail: carol@exa1mple.com\nCourse: Physics2");
        studentList.add("ID: 113\nName: Car3ol\nAge: 19\nE-mail: carol@exa32mple.com\nCourse: Physic3s");


        // Provide input for the scanner
        ByteArrayInputStream in = new ByteArrayInputStream("2\nN\n".getBytes());
        System.setIn(in);

        // Set the studentList in the StudentManagement object
        st.setStudentList((ArrayList<String>) studentList);

        st.deleteStudent();
        
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        // Assert that the student deletion was cancelled and the appropriate message was printed
        assertEquals("Enter student ID to delete: \n" +
                "-----------------------------------------------\n" +
                "Student found:\n" +
                "Student ID: 2\n" +
                "Name: Alice\n" +
                "Grade: B\n" +
                "-----------------------------------------------\n" +
                "Are you sure you want to delete this student? (Y/N): \n" +
                "-----------------------------------------------\n" +
                "Deletion cancelled.\n" +
                "-----------------------------------------------\n", outContent.toString());
    }
// works 
    @Test
    public void testStudentReport() {
        student studentInstance = new student();
        ArrayList<String> studentList = studentInstance.getStudentList();
        studentList.add("ID: 111\nName: Carol\nAge: 19\nE-mail: carol@example.com\nCourse: Physics");

        // Redirect console output to capture it
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        studentInstance.studentReport();
        String capturedOutput = consoleOutput.toString();

        assertTrue(capturedOutput.contains("Student Report:"));
        assertTrue(capturedOutput.contains("ID: 111"));
        assertTrue(capturedOutput.contains("Name: Carol"));
        assertTrue(capturedOutput.contains("Age: 19"));
        assertTrue(capturedOutput.contains("E-mail: carol@example.com"));
        assertTrue(capturedOutput.contains("Course: Physics"));
    }
}
