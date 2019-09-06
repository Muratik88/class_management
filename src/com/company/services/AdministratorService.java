package com.company.services;

import com.company.model.*;

public interface AdministratorService {
    void createCourser(Course course);
    void createGroup(Group group);
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    void createUser(User user);
    void registerStudentToGroup(StudentGroup studentGroup);
    boolean checkCredentials(String login, String password);

//    void registerStudent(Student student, Group group);
//    void unRegisterStudent(Student student, Group group);
}