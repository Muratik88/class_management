package com.company.services.impl;

import com.company.model.*;
import com.company.services.AdministratorService;
import com.company.services.DbService;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {
    @Override
    public void createCourse(Course course) {
        DbService dbService = new DbServiceImpl();
        if (dbService.createCourse(course)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error creating!");
        }
    }

    @Override
    public void updateCourse(Course course) {
        DbService dbService = new DbServiceImpl();
        if (dbService.updateCourse(course)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error deleting!");
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
    public void createUser(User user) {
        DbService dbService = new DbServiceImpl();
        if (dbService.appendUser(user)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error creating!");
        }
    }

    @Override
    public void registerStudentToGroup(StudentGroup studentGroup) {

    }

    @Override
    public boolean checkCredentials(String login, String password) {
        DbService dbService = new DbServiceImpl();
        if (dbService.checkUser(login, password)){
            return true;
        }else {
            return false;
        }
    }

    public List<Teacher> getTeachersList(){
        DbService dbService = new DbServiceImpl();
        return  dbService.getTeachersList();
    }

    public List<Course> getCoursesList(){
        DbService dbService = new DbServiceImpl();
        return dbService.getCourseList();
    }

    @Override
    public void deleteCourse(int course_id) {
        DbService dbService = new DbServiceImpl();
        if (dbService.deleteCourse(course_id)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error deleting!");
        }
    }

    @Override
    public List<Student> getStudentsList() {
        DbService dbService = new DbServiceImpl();
        return dbService.getStudentsList();
    }

    @Override
    public void deleteStudents(int students_id) {
        DbService dbService = new DbServiceImpl();
        if (dbService.deleteStudents(students_id)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error deleting!");
        }
    }

    @Override
    public void updateStudent(Student student) {
        DbService dbService = new DbServiceImpl();
        if (dbService.updateStudent(student)){
            System.out.println("Successfully!");
        }else{
            System.out.println("Error deleting!");
        }
    }
}
