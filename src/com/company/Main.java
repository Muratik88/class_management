package com.company;

import com.company.model.Course;
import com.company.services.AdministratorService;
import com.company.services.DbService;
import com.company.services.impl.AdministratorServiceImpl;
import com.company.services.impl.DbServiceImpl;

public class Main {

    public static void main(String[] args) {
        AdministratorService service = new AdministratorServiceImpl();
        Course course = new Course("English",1000,3);
        service.createCourser(course);
    }
}
