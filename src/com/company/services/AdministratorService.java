package com.company.services;

import com.company.model.*;

import java.util.List;

public interface AdministratorService {
    void createCourser(Course course);
    void createGroup(Group group);
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    void createUser(User user);
    void registerStudentToGroup(StudentGroup studentGroup);
    boolean checkCredentials(String login, String password);
    List<Teacher> getTeacherList();
    List<Course> getCoursesList();

//    void registerStudent(Student student, Group group);
//    void unRegisterStudent(Student student, Group group);
}