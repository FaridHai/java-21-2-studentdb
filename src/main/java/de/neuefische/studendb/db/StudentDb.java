package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDb {

    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentDb(ArrayList<Student> students) {
            this.studentList = students;
        }

    public List<Student> list() {
            return Collections.unmodifiableList(studentList);
        }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < studentList.size(); i++) {
            result += studentList.get(i) + "\n";
        }
        return result;
    }

    public Student randomStudent() {
        int index = (int) Math.floor(Math.random() * studentList.size());
            return studentList.get(index);
    }
    public void add(Student student) {
        studentList.add(student);
    }

    public void remove(Student student) {
       while(studentList.remove(student)){
       }
    }

    public Student findById(String findById){
        for(Student student : studentList){
            if(student.getId() == findById){
                return student;
            }
        }
        return null;
    }

    public void removeById(String idToRemove) {
        remove(findById(idToRemove));
    }
}
