package com.company.services;

import com.company.model.*;

import java.util.List;

public interface AdministratorService {
    void createCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int course_id);
    List<Course> getCoursesList();

    void createGroup(Group group);

    void createTeacher(Teacher teacher);
    List<Teacher> getTeachersList();

    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudents(int students_id);
    List<Student> getStudentsList();

    void createUser(User user);
    boolean checkCredentials(String login, String password);
    void registerStudentToGroup(StudentGroup studentGroup);


//    void registerStudent(Student student, Group group);
//    void unRegisterStudent(Student student, Group group);
}