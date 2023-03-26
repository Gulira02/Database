package service.impl;
import db.Database;
import gender.Gender;
import model.Student;
import service.StudentService;
import java.util.*;

public class StudentServiceImpl implements StudentService {
    private List<Database>databases;

    public StudentServiceImpl(List<Database> databases) {
        this.databases = databases;
    }

    @Override
    public Student addStudent(Student student) {
        for (Database database : databases) {
            database.getStudents().add(student);
        }

        return student;
    }

    @Override
    public Student getStudentById(int id) {
        for (Database database:databases) {
            for (Student student:database.getStudents()) {
                if(student.getId()==id){
                    return student;
                }
            }

        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Database database : databases) {
            students.addAll(database.getStudents());
        }
        return students;
    }

    @Override
    public String updateStudentFullName(int id, String fullName) {
        for (Database database : databases) {
            for (Student student:database.getStudents()) {
                if(student.getId()==id){
                    student.setFullName(fullName);
                }
            }}
        return "Successfully changed the name of the students ";
    }

    @Override
    public List<Student> filterByGender() {
        for (Database database : databases) {
            for (Student student : database.getStudents()) {
                String input = new Scanner(System.in).nextLine();
                if (input.equals("1")) {
                    database.getStudents().stream().filter(gen -> gen.getGender()
                            .equals(Gender.FEMALE)).toList().forEach(System.out::println);
                } else if (input.equals("2")) {
                    database.getStudents().stream().filter(gen -> gen.getGender()
                            .equals(Gender.MALE)).toList().forEach(System.out::println);
                }
            }
        }
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        for (Database database1 : databases) {
            Iterator<Student> iterator = database1.getStudents().iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getId() == id) {
                    iterator.remove();
                }
            }


        }
    }
}


