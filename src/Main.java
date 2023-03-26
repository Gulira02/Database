import db.Database;
import exception.MyException;
import gender.Gender;
import model.Group;
import model.Student;
import service.impl.GroupServiceImpl;
import service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       List<Group>groups=new ArrayList<>();
        groups.add(new Group(1,"Java","Back-End",10));
        groups.add(new Group(2,"Javascript","Front-End",5));

        List<Student>students=new ArrayList<>();
        students.add(new Student("Felina",1,20, Gender.FEMALE));
        students.add(new Student("Arkadi",2,21, Gender.MALE));
        students.add(new Student("Ignat",3,22, Gender.MALE));
        students.add(new Student("Serhan",4,23, Gender.MALE));
        students.add(new Student("Kiril",5,24, Gender.MALE));

        GroupServiceImpl groupService=new GroupServiceImpl();
        Group group1=new Group(1,"java","junior",6);
        Group group2=new Group(2,"java3","junior",8);


        StudentServiceImpl studentService=new StudentServiceImpl();




                while (true) {
               try {
                   int com = new Scanner(System.in).nextInt();

                System.out.println("""
                        1: Add New Group(Group group);
                                        
                        2: Get Group By Id(int id);
                                        
                        3: Get All Groups();
                                        
                        4: Update Group Name(int id, String groupName);
                                        
                        5: Filter By Year(int year, String ascDesc); 
                                        
                        6: Sort Group By Year(String ascDesc);
                                        
                        7: Delete Group By Id(int id);
                        
                        8: Add new students
                        
                        9: Get student by ID
                        
                        10: Get all students
                        
                        11: Filter by gender
                         
                        12: Delete student by Id""");

                switch (com) {
                    case 1:
                        groupService.addNewGroup((new Group(1,"Java","Back-End",12)));
                    case 2:
                        groupService.getGroupById((1));
                    case 3:
                        groupService.getAllGroups();
                    case 4:
                        groupService.updateGroupName(4, "Python");
                    case 5:
                        groupService.filterByYear(2, "asc");
                    case 6:
                        groupService.sortGroupByYear("desc");
                    case 7:
                        groupService.deleteGroupById(1);
                    case 8:
                        studentService.addStudent();
                    case 9:
                        studentService.getStudentById();
                    case 10:
                        studentService.getAllStudents();
                    case 11:
                        studentService.filterByGender();
                    case 12:
                        studentService.deleteStudentById();

                    default:
                        System.out.println("Mynday comanda jok");

                }


                   throw new MyException("Wrong");

            }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
      }
    }
}