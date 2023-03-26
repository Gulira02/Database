package service.impl;
import db.Database;
import model.Group;
import service.GroupService;
import java.util.*;
public class GroupServiceImpl  implements GroupService {
    private List<Database> databases;

    public GroupServiceImpl(List<Database> databases) {
        this.databases = databases;
    }

    @Override
    public String addNewGroup(Group group) {

        for (Database database : databases) {
            database.getGroups().add(group);
            System.out.println(group);
        }

        return "Group successfully added";
    }

    @Override
    public String getGroupById(int id) {
        for (Database database1 : databases) {
            for (Group group1 : database1.getGroups()) {
                if (group1.getId() == id) {
                    System.out.println(group1);
                }
            }
        }
        return "ID groups";
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        for (Database database : databases) {
            groups.addAll(database.getGroups());
        }
        return groups;

    }

        @Override
        public Database updateGroupName(int id, String groupName) {
            for (Database database : databases) {
                for (Group  group :database.getGroups() ) {
                    if(group.getId()==(id)){
                        group.setName(groupName);
                        System.out.println(group);
                    }
                }

            }
            return null;
        }

    @Override
    public List<Group> filterByYear(int year, String ascDesc) {
        List<Group> groups = new ArrayList<>();
        for (Database database : databases) {
            groups.addAll(database.getGroups());
        }
        List<Group> group1;
        if (ascDesc.equalsIgnoreCase("asc")) {//ascending восходящий,
            group1 = groups.stream().filter(x -> x.getYear() > year).toList();
        } else {
            group1 = groups.stream().filter(x -> x.getYear() < year).toList();//  descending нисходящий
        }
        return group1;
    }

    @Override
    public List<Group> sortGroupByYear(String ascDesc) {
        List<Group> groups = new ArrayList<>();
        for (Database database : databases) {
            groups.addAll(database.getGroups());
        }
        List<Group> group;
        if (ascDesc.equalsIgnoreCase("asc")) {
            group = groups.stream().sorted(Comparator.comparing(Group::getYear))
                    .toList();
        }
        return groups;
    }

    @Override
    public void deleteGroupById(int id) {
        for (Database database1 : databases) {
            Iterator<Group> iterator = database1.getGroups().iterator();
            while (iterator.hasNext()) {
                Group group = iterator.next();
                if (group.getId() == id) {
                    iterator.remove();
                }
            }


        }

    }

}





