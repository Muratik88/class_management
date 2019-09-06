package com.company.services;

import com.company.model.*;

public interface DbService {

    boolean createCourse(Course course);
    boolean appendTeacher(Teacher teacher);
    boolean createGroup(Group group);
    boolean appendStudent(Student student);
    boolean appendUser(User user);
    boolean checkUser(String login, String password);

}
