package service.impl;
import db.Database;
import gender.Gender;
import model.Student;
import service.StudentService;
import java.util.*;

public class StudentServiceImpl implements StudentService {
    private List<Database>databases;
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
        return null;
    }

    @Override
    public String updateStudentFullName(int id, String fullName) {
        for (Database database : databases) {
            for (Student student:database.getStudents()) {
                if(student.getId()==id){
                    student.setFullName(fullName);
                }
            }}
        return "Student full name ozgoruldu ";
    }


    @Override
    public List<Student> filterByGender() {
        //with stream (1 ди басканда female, 2 ни басканда male кылып фильтрлесин)

        for (Database database : databases) {
            for (Student student : database.getStudents()) {
                String input= new Scanner(System.in).nextLine();
                if(input.equals("1")){
                database.getStudents().stream().filter(gen->gen.getGender()
                        .equals(Gender.FEMALE)).toList().forEach(System.out::println);
                    } else if (input.equals("2")) {
                    database.getStudents().stream().filter(gen->gen.getGender()
                            .equals(Gender.MALE)).toList().forEach(System.out::println);
                }
                return Collections.singletonList(student);
            }
                }
        return null;
        }



    @Override
    public void deleteStudentById(int id) {
        for (Database database1 : databases) {
            for (Student student : database1.getStudents()) {
                if(student.getId()==id){
                    databases.remove(student);

                }

            }
        }
    }
    }


