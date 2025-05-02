package Repo;

// import Entity.Book;
import Entity.Student;
import java.util.*;

public class StudentRepository {
    private Map<String, Student> students = new HashMap<>();
    {
        students.put("S101", new Student("S101", "Amit", "amit@gmail.com", "9876543210"));
        students.put("S102", new Student("S102", "Neha", "neha@gmail.com", "8765432109"));
        students.put("S103", new Student("S103", "Rahul", "rahul@gmail.com", "7654321098"));
        students.put("S104", new Student("S104", "Sneha", "sneha@gmail.com", "9988776655"));
        students.put("S105", new Student("S105", "Karan", "karan@gmail.com", "9123456780"));
        students.put("S106", new Student("S106", "Priya", "priya@gmail.com", "9012345678"));
        students.put("S107", new Student("S107", "Ankit", "ankit@gmail.com", "8899776655"));
        students.put("S108", new Student("S108", "Riya", "riya@gmail.com", "7788996655"));
        students.put("S109", new Student("S109", "Manav", "manav@gmail.com", "9090909090"));
        students.put("S110", new Student("S110", "Meena", "meena@gmail.com", "8008008008"));
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public boolean exists(String id) {
        return students.containsKey(id);
    }

    public int size() {
        return students.size();
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public void removeStudent(String id) {
        students.remove(id);
    }
}
