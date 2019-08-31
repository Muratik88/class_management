package com.company.services;

import com.company.model.Course;
import com.company.model.Group;
import com.company.model.Student;
import com.company.model.Teacher;

public interface DbService {

    boolean createCourse(Course course);
    boolean appendTeacher(Teacher teacher);
    boolean createGroup(Group group);
    boolean appendStudent(Student student);
}
