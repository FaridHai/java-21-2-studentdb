package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.*;

public class StudentDb {

    private Map<String, Student> studentMap = new HashMap<>();

    public StudentDb(Student[] students) {
        for (Student student : students) {
            add(student);
        }
    }

    public Map<String, Student> list() {
            return Collections.unmodifiableMap(studentMap);
        }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Student> mapEntry : studentMap.entrySet()) {
            result.append(mapEntry.getValue()).append("\n");
        }
        return result.toString();
    }

    /* ALTERNATIVLÖSUNG
        @Override
    public String toString() {
        return "StudentDb{" +
                "studentMap=" + studentMap +
                '}';
    }
    */

    /*public Student randomStudent() {
        //1. Keys bekommen und in ArrayList speichern
        ArrayList<String> keysAsArray= new ArrayList<>(studentMap.keySet());
        //2. Über die Größe vom Array eine zufällige Zahl suchen
        int index = (int) Math.floor(Math.random() * keysAsArray.size());
        //3. Key abspeichern
        String key = keysAsArray.get(index).toString();
        //4. Diesen Key nehmen und ausgeben
        return studentMap.get(key);
    }*/

    public void add(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void remove(String key) {
       studentMap.remove(key);

    }

    public Student findById(String id){
        return studentMap.get(id);
    }

    /*public void removeById(String idToRemove) {
        remove(findById(idToRemove));
    }*/
}
