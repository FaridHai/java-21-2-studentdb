package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDbTest {

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        String actual = studentDb.list().toString();

        // Then
        String expected = "[Student{name='Jane', id='42'}"
                + ", Student{name='Klaus', id='13'}"
                + ", Student{name='Franky', id='100'}]";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testListArray() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        List<Student> actual = studentDb.list();

        // Then
        ArrayList<Student> expected = new ArrayList<>();
        expected.add(new Student("Jane", "42"));
        expected.add(new Student("Klaus", "13"));
        expected.add(new Student("Franky", "100"));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding Students")
    public void testToAddStudent() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));

        StudentDb studentDb = new StudentDb(students);

        // When
        students.add(new Student("TestStudent", "15"));
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n"
                + "Student{name='TestStudent', id='15'}\n";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Test to Remove Student")
    public void testToRemoveStudent() {
        // Given
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jane", "42"));
        students.add(new Student("Klaus", "13"));
        students.add(new Student("Franky", "100"));
        students.add(new Student("TestStudent", "15"));

        StudentDb studentDb = new StudentDb(students);

        // When
        students.remove(new Student("TestStudent", "15"));
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find Student by ID")
    void findById() {
        //GIVEN
        ArrayList<Student> students = new ArrayList<>();
        StudentDb studentDb = new StudentDb(students);

        studentDb.add(new Student("Jane", "42"));
        studentDb.add(new Student("Klaus", "13"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("TestStudent", "15"));
        studentDb.add(new Student("TestStudent", "15"));

        //THEN
        Student actual = studentDb.findById("15");

        //WHEN
        Student expected = (new Student("TestStudent", "15"));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove Student by ID")
    void removeById() {
        //GIVEN
        ArrayList<Student> students = new ArrayList<>();
        StudentDb studentDb = new StudentDb(students);

        studentDb.add(new Student("Jane", "42"));
        studentDb.add(new Student("Klaus", "13"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("TestStudent", "15"));
        studentDb.add(new Student("TestStudent", "15"));

        //THEN
        studentDb.removeById("15");
        String actual = studentDb.toString();
        //WHEN
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }
}