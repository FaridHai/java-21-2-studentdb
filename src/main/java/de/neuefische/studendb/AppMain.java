package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.Student;

import java.util.ArrayList;

public class AppMain {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        StudentDb studentDb = new StudentDb(students);

        studentDb.add(new Student("Jane", "42"));
        studentDb.add(new Student("Klaus", "13"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("Franky", "100"));
        studentDb.add(new Student("Franky", "100"));


//        studentDb.remove(new Student("Franky", "100"));

//        for(int i=0; i < 5; i++){
//            System.out.println(studentDb.randomStudent());
//        }

        System.out.println(studentDb.toString());
        System.out.println(studentDb.findById("13")+ "\n");
        studentDb.removeById("100");
        System.out.println(studentDb.toString());

    }
}
