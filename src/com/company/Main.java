package com.company;

import com.company.model.Course;
import com.company.model.Group;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.services.AdministratorService;
import com.company.services.DbService;
import com.company.services.impl.AdministratorServiceImpl;
import com.company.services.impl.DbServiceImpl;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AdministratorService service = new AdministratorServiceImpl();

//        Course course = new Course("English",1000,3);
//        service.createCourse(course);

//        Teacher teacher = new Teacher("Жылдыз", "9965515544330","ул.Ленина 15", null);
//        service.createTeacher(teacher);

//        Group group = new Group(1,1, new Date());
//        service.createGroup(group);

//        Student student = new Student("Чынгыз", "996332211","ул.Месароша 123",null);
//        service.createStudent(student);
    }
}
