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
        groups.add(new Group(2,"Javascript","Front-End",6));
        groups.add(new Group(3,"C#","Front-End",3));

        List<Student>students=new ArrayList<>();
        students.add(new Student("Felina",1,20, Gender.FEMALE));
        students.add(new Student("Arkadi",2,21, Gender.MALE));
        students.add(new Student("Ignat",3,22, Gender.MALE));
        students.add(new Student("Serhan",4,23, Gender.MALE));
        students.add(new Student("Kiril",5,24, Gender.MALE));

        List<Database> databases = List.of(new Database(groups,students));
        GroupServiceImpl groupService=new GroupServiceImpl(databases);
        StudentServiceImpl studentService=new StudentServiceImpl(databases);


        try{
            System.out.println("Enter the password ");
            int login = new Scanner(System.in).nextInt();
        if(login==280709){
            while (true) {
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
                        12: UpDate full name;
                        13: Delete student by Id""");

                    int com = new Scanner(System.in).nextInt();
                switch (com) {
                    case 1:
                        System.out.println("Enter the Id: ");
                        int id = new Scanner(System.in).nextInt();
                        System.out.println("Enter the group name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("Enter the description: ");
                        String description=new Scanner(System.in).nextLine();
                        System.out.println("Enter the year: ");
                        int year=new Scanner(System.in).nextInt();
                        System.out.println(groupService.addNewGroup(new Group(id,name,description,year)));
                        break;
                    case 2:
                        System.out.println("Enter the Id: ");
                        int id0 = new Scanner(System.in).nextInt();
                        System.out.println(groupService.getGroupById((id0)));
                        break;
                    case 3:
                        System.out.println(groupService.getAllGroups());
                        break;
                    case 4:
                        System.out.println("Enter the Id and group name: ");
                        int id1 = new Scanner(System.in).nextInt();
                        String upName = new Scanner(System.in).nextLine();
                        System.out.println(groupService.updateGroupName(id1, upName));
                        break;
                    case 5:
                        System.out.println("Enter the year: ");
                        int year1=new Scanner(System.in).nextInt();
                        System.out.println("Enter the asc/desk: ");
                        String ascDesc = new Scanner(System.in).nextLine();
                        System.out.println(groupService.filterByYear(year1, ascDesc));
                        break;
                    case 6:
                        System.out.println("Enter the asc/desk: ");
                        String ascDes = new Scanner(System.in).nextLine();
                        System.out.println(groupService.sortGroupByYear(ascDes));
                        break;
                    case 7:
                        System.out.println("Enter the Id: ");
                        int iD = new Scanner(System.in).nextInt();
                        groupService.deleteGroupById(iD);
                        break;
                    case 8:
                        System.out.println("Enter the group name: ");
                        String fullName = new Scanner(System.in).nextLine();
                        System.out.println("Enter the Id: ");
                        int idSt = new Scanner(System.in).nextInt();
                        System.out.println("Enter the age: ");
                        int age=new Scanner(System.in).nextInt();
                        System.out.println("Enter the Gender(FEMALE/MALE): ");
                        String gender=new Scanner(System.in).nextLine();
                        System.out.println(studentService.addStudent((
                        new Student(fullName,idSt,age,Gender.valueOf(gender)))));
                        break;
                    case 9:
                        System.out.println("Enter the Id: ");
                        int id4 = new Scanner(System.in).nextInt();
                        System.out.println(studentService.getStudentById(id4));
                        break;
                    case 10:
                        System.out.println(studentService.getAllStudents());
                        break;
                    case 11:
                        System.out.println("Enter the number (1/2): ");
                        System.out.println(studentService.filterByGender());
                        break;
                    case 12:
                        System.out.println("Enter the student name: ");
                        String updateName = new Scanner(System.in).nextLine();
                        System.out.println("Enter the Id: ");
                        int id9 = new Scanner(System.in).nextInt();
                        System.out.println(studentService.updateStudentFullName(id9, updateName));
                        break;
                    case 13:
                        System.out.println("Enter the Id: ");
                        int id5 = new Scanner(System.in).nextInt();
                        studentService.deleteStudentById(id5);
                        break;

                    default:
                        System.out.println("There is no such command");
                }
            }
      }
    else{
        throw new MyException("Error");
        }
        } catch (MyException e){
            System.out.println(e.getMessage());}
    }
    }
