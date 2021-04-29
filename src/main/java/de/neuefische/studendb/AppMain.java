package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppMain {

    public static void main(String[] args) {
        //Map<String, Student> students = new HashMap<>();
        Student[] students = new Student[2];
        Student student1 = new Student("Johnny", "9");
        Student student2 = new Student("Albus", "12");
        students[0] = student1;
        students[1] = student2;
        StudentDb studentDb = new StudentDb(students);
        System.out.println(studentDb.toString());

        studentDb.add(new Student("Jane", "42"));
        studentDb.add(new Student("Klaus", "13"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("Franky", "100"));

        System.out.println(studentDb.toString());
        System.out.println(studentDb.findById("13")+ "\n");
        //studentDb.removeById("100");
        System.out.println(studentDb.toString());

    }
}
