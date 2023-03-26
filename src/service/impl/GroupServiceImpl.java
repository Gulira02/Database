package service.impl;
import db.Database;
import model.Group;
import service.GroupService;
import java.util.*;
import java.util.stream.Collectors;

    public class GroupServiceImpl extends Group implements GroupService {
        private List<Database> databases;

        public GroupServiceImpl(int id, String name, String description, int year, List<Database> databases) {
            super(id, name, description, year);
            this.databases = databases;
        }


        public GroupServiceImpl(List<Database> databases) {
            this.databases = databases;
        }

        @Override
        public String addNewGroup(Group group) {

            for (Database database : databases) {
                database.getGroups().add(group);
                System.out.println(group);
            }

            return "Gruppa achyldy";
        }

        @Override
        public String getGroupById(int id) {
            for (Database database1 : databases) {
                for (Group group1 :database1.getGroups()) {
                    if(group1.getId()==id){
                        System.out.println(group1);
                    }
                }
            }
            return "Gruppanyn idsi";
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
                    }
                }

                return database;
            }


            return null;
        }

        @Override
        public List<Group> filterByYear(int year, String ascDesc) {
            // (asc ди басканда ascending, desc ди басканда descending кылып сорттосун)

            List<Group> groupList = new ArrayList<>();
            List<Group> filteredList = new ArrayList<>();
            for (Group group : groupList) {
                if (group.getYear() == year) {
                    filteredList.add(group);
                }
            }
            Comparator<Group> yearComparator = new Comparator<>() {
                public int compare(Group g1, Group g2) {
                    if (ascDesc.equalsIgnoreCase("asc")) {
                        return g1.getYear() - g2.getYear();
                    } else {
                        return g2.getYear() - g1.getYear();
                    }
                }
            };
            Collections.sort(filteredList, yearComparator);
            return filteredList;
        }

        @Override
        public List<Group> sortGroupByYear(String ascDesc) {

            List<Group> groupList = new ArrayList<>();
            Comparator<Group> yearComparator = new Comparator<>() {
                public int compare(Group o1, Group o2) {
                    if (ascDesc.equalsIgnoreCase("asc")) {
                        return o1.getYear() - o2.getYear();
                    } else {
                        return o2.getYear() - o1.getYear();
                    }
                }
            };
            Collections.sort(groupList, yearComparator);
            return groupList;
        }

        @Override
        public void deleteGroupById(int id) {
            for (Database database1 : databases) {
                for (Group group : database1.getGroups()) {
                    if(group.getId()==id){
                        databases.remove(group);

                    }

                }
            }
        }
    }


