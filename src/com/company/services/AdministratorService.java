package com.company.services;

import com.company.model.*;

public interface AdministratorService {
    void createCourser(Course course);
    void createGroup(Group group);
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    void registerStudentToGroup(StudentGroup studentGroup);

//    void registerStudent(Student student, Group group);
//    void unRegisterStudent(Student student, Group group);
}