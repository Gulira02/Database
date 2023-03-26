package service;

import model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    String updateStudentFullName(int id, String fullName);

    //with stream (1 ди басканда female, 2 ни басканда male кылып фильтрлесин)
    List<Student> filterByGender();

    void deleteStudentById(int id);
}
