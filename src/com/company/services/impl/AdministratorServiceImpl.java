package com.company.services.impl;

import com.company.model.*;
import com.company.services.AdministratorService;
import com.company.services.DbService;

public class AdministratorServiceImpl implements AdministratorService {
    @Override
    public void createCourser(Course course) {
        DbService dbService = new DbServiceImpl();
        if (dbService.createCourse(course)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error creating!");
        }
    }

    @Override
    public void createGroup(Group group) {
        DbService dbService = new DbServiceImpl();
        if (dbService.createGroup(group)){
            System.out.println("Successfully!");
        }else {
            System.out.println("Error creating!");
        }
    }

    @Override
    public void createTeacher(Teacher teacher) {
        DbService dbService = new DbServiceImpl();
        if (dbService.appendTeacher(teacher)){
            System.out.println("Successfully!");
        }else {
            System.out.println("Error creating!");
        }
    }

    @Override
    public void createStudent(Student student) {
        DbService dbService = new DbServiceImpl();
        if (dbService.appendStudent(student)){
            System.out.println("Successfully!");
        }else {
            System.out.println("Error creating!");
        }
    }

    @Override
    public void registerStudentToGroup(StudentGroup studentGroup) {

    }
}
