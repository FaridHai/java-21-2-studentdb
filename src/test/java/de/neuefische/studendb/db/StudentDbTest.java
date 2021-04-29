package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

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
        ArrayList<Student> actual = studentDb.list();

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
}