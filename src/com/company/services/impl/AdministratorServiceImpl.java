package com.company.services.impl;

import com.company.model.Course;
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
}
