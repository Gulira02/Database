package db;

import model.Group;
import model.Student;

import java.util.List;

public class Database {
    private List<Group> groups;
    private List<Student> students;

    public Database(List<Group> groups, List<Student> students) {
        this.groups = groups;
        this.students = students;
    }
    public Database(){}

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Database{" +
                "groups=" + groups +
                ", students=" + students +
                '}';
    }
}

