package service;

import db.Database;
import model.Group;
import service.impl.GroupServiceImpl;

import java.util.List;

public interface GroupService {
    String addNewGroup(Group group);

    // with stream
    String getGroupById(int id);

    //with stream
    List<Group> getAllGroups();

    //with stream
    Database updateGroupName(int id, String groupName);

    //with stream (asc ди басканда ascending, desc ди басканда descending кылып сорттосун)
    List<Group>filterByYear(int year, String ascDesc);

    //with stream  (asc ди басканда ascending, desc ди басканда descending кылып сорттосун)
    List<Group>sortGroupByYear(String ascDesc);

    //with stream
    void deleteGroupById(int id);

}

