package com.company.services;

import com.company.model.*;

import java.util.List;

public interface DbService {

    boolean createCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourse(int course_id);
    List<Course> getCourseList();

    boolean appendStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudents(int student_id);
    List<Student> getStudentsList();

    boolean appendTeacher(Teacher teacher);
    List<Teacher> getTeachersList();

    boolean createGroup(Group group);

    boolean appendUser(User user);
    boolean checkUser(String login, String password);







}
